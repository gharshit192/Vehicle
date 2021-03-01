package di.module

import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class DatabaseModule {

    @Provides
    fun provideMongoDb(): MongoDatabase {
        return MongoClient(AppConstants.DB_HOST, AppConstants.DB_PORT).getDatabase(AppConstants.DB_NAME)
    }

}