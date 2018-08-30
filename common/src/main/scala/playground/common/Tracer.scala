package playground.common

import com.twitter.finagle.stats.DefaultStatsReceiver
import zipkin2.finagle.kafka.KafkaZipkinTracer

object Tracer {
  private val tracerConfig = KafkaZipkinTracer.Config.builder()
    .bootstrapServers("kafka")
    .topic("kafka")
    .build()

   val kafka: KafkaZipkinTracer = KafkaZipkinTracer.create(tracerConfig, DefaultStatsReceiver.get)
}
