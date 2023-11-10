package SQLLite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BDHelper (context: Context, factory: SQLiteDatabase.CursorFactory?)
    : SQLiteOpenHelper (context, DATABASE_NAME, factory, DATABASE_VERSION) {

        companion object {
            private val DATABASE_NAME ="BD_FireFootStore"
            private val DATABASE_VERSION = 1
            private val TABLA_CUSTOMERS = "CUSTOMER"
            private val COLUMN_ID = "IDCUSTOMER"
            private val COLUMN_NAMES = "NAMES"
            private val COLUMN_USERS = "USER"
            private val COLUMN_PASSWORDS = "PASSWORD"
            private val COLUMN_EMAILS = "EMAIL"
            private val COLUMN_PHONES = "PHONE"
        }

    override fun onCreate(db: SQLiteDatabase?) {
        var queryCreateTable =
            ("CREATE TABLE " + TABLA_CUSTOMERS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAMES + " TEXT,"
                + COLUMN_USERS + " TEXT,"
                + COLUMN_PASSWORDS + " TEXT,"
                + COLUMN_EMAILS + " TEXT,"
                + COLUMN_PHONES +  " TEXT)")
        db?.execSQL(queryCreateTable)

    }

    fun createRegister(names: String, user: String, password: String, email: String, phone: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAMES, names)
        contentValues.put(COLUMN_USERS, user)
        contentValues.put(COLUMN_PASSWORDS, password)
        contentValues.put(COLUMN_EMAILS, email)
        contentValues.put(COLUMN_PHONES, phone)
        db.insert(TABLA_CUSTOMERS, null, contentValues)
        db.close()
    }
    fun customerRegisters(): Cursor {
        val db = this.readableDatabase
        return db.rawQuery("SELECT * FROM " + TABLA_CUSTOMERS, null)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}