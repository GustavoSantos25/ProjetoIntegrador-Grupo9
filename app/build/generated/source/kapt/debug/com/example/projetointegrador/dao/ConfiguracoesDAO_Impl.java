package com.example.projetointegrador.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.projetointegrador.domain.Configuracoes;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ConfiguracoesDAO_Impl implements ConfiguracoesDAO {
  private final RoomDatabase __db;

  private final EntityDeletionOrUpdateAdapter<Configuracoes> __updateAdapterOfConfiguracoes;

  public ConfiguracoesDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__updateAdapterOfConfiguracoes = new EntityDeletionOrUpdateAdapter<Configuracoes>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `configuracoes` SET `id` = ?,`email` = ?,`vibrar` = ?,`notificacoes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Configuracoes value) {
        stmt.bindLong(1, value.getId());
        if (value.getEmail() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmail());
        }
        final int _tmp;
        _tmp = value.getVibrar() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getNotificacoes() ? 1 : 0;
        stmt.bindLong(4, _tmp_1);
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public Object updateConfiguracoes(final Configuracoes configuracoes,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfConfiguracoes.handle(configuracoes);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllConfiguracoes(final Continuation<? super List<Configuracoes>> p0) {
    final String _sql = "SELECT * FROM configuracoes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Configuracoes>>() {
      @Override
      public List<Configuracoes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfVibrar = CursorUtil.getColumnIndexOrThrow(_cursor, "vibrar");
          final int _cursorIndexOfNotificacoes = CursorUtil.getColumnIndexOrThrow(_cursor, "notificacoes");
          final List<Configuracoes> _result = new ArrayList<Configuracoes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Configuracoes _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final boolean _tmpVibrar;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfVibrar);
            _tmpVibrar = _tmp != 0;
            final boolean _tmpNotificacoes;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfNotificacoes);
            _tmpNotificacoes = _tmp_1 != 0;
            _item = new Configuracoes(_tmpId,_tmpEmail,_tmpVibrar,_tmpNotificacoes);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }

  @Override
  public Object getConfiguracoesForUser(final String aEmail,
      final Continuation<? super Configuracoes> p1) {
    final String _sql = "SELECT * FROM configuracoes WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (aEmail == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, aEmail);
    }
    return CoroutinesRoom.execute(__db, false, new Callable<Configuracoes>() {
      @Override
      public Configuracoes call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfVibrar = CursorUtil.getColumnIndexOrThrow(_cursor, "vibrar");
          final int _cursorIndexOfNotificacoes = CursorUtil.getColumnIndexOrThrow(_cursor, "notificacoes");
          final Configuracoes _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpEmail;
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            final boolean _tmpVibrar;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfVibrar);
            _tmpVibrar = _tmp != 0;
            final boolean _tmpNotificacoes;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfNotificacoes);
            _tmpNotificacoes = _tmp_1 != 0;
            _result = new Configuracoes(_tmpId,_tmpEmail,_tmpVibrar,_tmpNotificacoes);
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
}
