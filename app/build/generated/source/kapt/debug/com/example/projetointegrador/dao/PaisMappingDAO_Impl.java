package com.example.projetointegrador.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.projetointegrador.domain.PaisMapping;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PaisMappingDAO_Impl implements PaisMappingDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<PaisMapping> __insertionAdapterOfPaisMapping;

  public PaisMappingDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPaisMapping = new EntityInsertionAdapter<PaisMapping>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `paismapping` (`id`,`nomePortugues`,`nomeIngles`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, PaisMapping value) {
        stmt.bindLong(1, value.getId());
        if (value.getNomePortugues() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNomePortugues());
        }
        if (value.getNomeIngles() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNomeIngles());
        }
      }
    };
  }

  @Override
  public Object populatePaisesMapping(final List<PaisMapping> paises,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPaisMapping.insert(paises);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object addPais(final PaisMapping pais, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPaisMapping.insert(pais);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getPaisPortugues(final String country, final Continuation<? super String> p1) {
    final String _sql = "SELECT nomePortugues FROM paismapping WHERE nomeIngles like ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (country == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, country);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            _result = _cursor.getString(0);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p1);
  }

  @Override
  public Object testIsEmpty(final Continuation<? super Integer> p0) {
    final String _sql = "SELECT max(id) FROM paismapping";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
