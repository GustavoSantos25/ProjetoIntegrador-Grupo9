package com.example.projetointegrador.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.projetointegrador.domain.FilmeReplace;
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
public final class FilmeReplaceDAO_Impl implements FilmeReplaceDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FilmeReplace> __insertionAdapterOfFilmeReplace;

  public FilmeReplaceDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFilmeReplace = new EntityInsertionAdapter<FilmeReplace>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `filmes` (`id`,`nome`,`pais`,`dataLancamento`,`diretor`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FilmeReplace value) {
        stmt.bindLong(1, value.getId());
        if (value.getNome() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getNome());
        }
        if (value.getPais() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPais());
        }
        if (value.getDataLancamento() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDataLancamento());
        }
        if (value.getDiretor() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDiretor());
        }
      }
    };
  }

  @Override
  public Object addFilmeReplace(final FilmeReplace filmeReplace,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfFilmeReplace.insert(filmeReplace);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object getAllFilmesReplace(final Continuation<? super List<FilmeReplace>> p0) {
    final String _sql = "SELECT * FROM FILMES";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<FilmeReplace>>() {
      @Override
      public List<FilmeReplace> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
          final int _cursorIndexOfPais = CursorUtil.getColumnIndexOrThrow(_cursor, "pais");
          final int _cursorIndexOfDataLancamento = CursorUtil.getColumnIndexOrThrow(_cursor, "dataLancamento");
          final int _cursorIndexOfDiretor = CursorUtil.getColumnIndexOrThrow(_cursor, "diretor");
          final List<FilmeReplace> _result = new ArrayList<FilmeReplace>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final FilmeReplace _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNome;
            _tmpNome = _cursor.getString(_cursorIndexOfNome);
            final String _tmpPais;
            _tmpPais = _cursor.getString(_cursorIndexOfPais);
            final String _tmpDataLancamento;
            _tmpDataLancamento = _cursor.getString(_cursorIndexOfDataLancamento);
            final String _tmpDiretor;
            _tmpDiretor = _cursor.getString(_cursorIndexOfDiretor);
            _item = new FilmeReplace(_tmpId,_tmpNome,_tmpPais,_tmpDataLancamento,_tmpDiretor);
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
