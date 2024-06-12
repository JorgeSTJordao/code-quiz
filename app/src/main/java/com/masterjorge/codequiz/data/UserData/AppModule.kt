package com.masterjorge.codequiz.data.UserData

import android.app.Application
import androidx.room.Room


object AppModule {

    fun provideMyDataBase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app,
            UserDatabase::class.java,
            "my_db"
        ).build()
    }

    fun provideMyRepository(userdb: UserDatabase): Repository {
        return UserRepository(userdb.userDao())
    }
}