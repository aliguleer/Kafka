import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ProducerExample {
    public static void main(String[] args) {
        String topicName="search";
        String[] dizi={"çanta","cüzdan","bla bla","falanfisman"};
        Properties configPro= new Properties();
        configPro.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        configPro.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.ByteArraySerializer");
        configPro.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        Producer producer = new KafkaProducer<String,String>(configPro);

        for (String name:dizi
             ) {

            ProducerRecord<String,String> rec = new ProducerRecord<String, String>
                    (topicName,name);
            producer.send(rec);
           /// TimeUnit.SECONDS.sleep(2);
        }


        producer.close();


    }
}
