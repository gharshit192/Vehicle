package di.module

import dagger.Module
import dagger.Provides
import kafka.KafkaService
import testService.FakeKafkaService

@Module
class KafkaServiceTestModule {

    @Provides
    fun provideKafkaService(
    ): KafkaService {

        return FakeKafkaService()
    }

}