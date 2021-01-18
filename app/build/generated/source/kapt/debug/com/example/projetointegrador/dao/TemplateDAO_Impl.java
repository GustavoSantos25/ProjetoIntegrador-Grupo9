package com.example.projetointegrador.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.projetointegrador.domain.Template;
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
public final class TemplateDAO_Impl implements TemplateDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Template> __insertionAdapterOfTemplate;

  public TemplateDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTemplate = new EntityInsertionAdapter<Template>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `template` (`id`,`perguntaPrimeiraMetade`,`perguntaSegundaMetade`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Template value) {
        stmt.bindLong(1, value.getId());
        if (value.getPerguntaPrimeiraMetade() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPerguntaPrimeiraMetade());
        }
        if (value.getPerguntaSegundaMetade() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPerguntaSegundaMetade());
        }
      }
    };
  }

  @Override
  public Object addTemplateQuestion(final Template template, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTemplate.insert(template);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllTemplates(final Continuation<? super List<Template>> p0) {
    final String _sql = "SELECT * FROM TEMPLATE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Template>>() {
      @Override
      public List<Template> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPerguntaPrimeiraMetade = CursorUtil.getColumnIndexOrThrow(_cursor, "perguntaPrimeiraMetade");
          final int _cursorIndexOfPerguntaSegundaMetade = CursorUtil.getColumnIndexOrThrow(_cursor, "perguntaSegundaMetade");
          final List<Template> _result = new ArrayList<Template>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Template _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpPerguntaPrimeiraMetade;
            _tmpPerguntaPrimeiraMetade = _cursor.getString(_cursorIndexOfPerguntaPrimeiraMetade);
            final String _tmpPerguntaSegundaMetade;
            _tmpPerguntaSegundaMetade = _cursor.getString(_cursorIndexOfPerguntaSegundaMetade);
            _item = new Template(_tmpId,_tmpPerguntaPrimeiraMetade,_tmpPerguntaSegundaMetade);
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
}
