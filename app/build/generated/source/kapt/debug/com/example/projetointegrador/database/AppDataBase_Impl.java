package com.example.projetointegrador.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.projetointegrador.dao.ConfiguracoesDAO;
import com.example.projetointegrador.dao.ConfiguracoesDAO_Impl;
import com.example.projetointegrador.dao.FilmeReplaceDAO;
import com.example.projetointegrador.dao.FilmeReplaceDAO_Impl;
import com.example.projetointegrador.dao.PaisMappingDAO;
import com.example.projetointegrador.dao.PaisMappingDAO_Impl;
import com.example.projetointegrador.dao.TemplateDAO;
import com.example.projetointegrador.dao.TemplateDAO_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDataBase_Impl extends AppDataBase {
  private volatile TemplateDAO _templateDAO;

  private volatile FilmeReplaceDAO _filmeReplaceDAO;

  private volatile ConfiguracoesDAO _configuracoesDAO;

  private volatile PaisMappingDAO _paisMappingDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `template` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `perguntaPrimeiraMetade` TEXT NOT NULL, `perguntaSegundaMetade` TEXT NOT NULL, `tipoDePergunta` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `filmes` (`id` INTEGER NOT NULL, `nome` TEXT NOT NULL, `pais` TEXT NOT NULL, `dataLancamento` TEXT NOT NULL, `diretor` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `configuracoes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `email` TEXT NOT NULL, `vibrar` INTEGER NOT NULL, `notificacoes` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `paismapping` (`id` INTEGER NOT NULL, `nomePortugues` TEXT NOT NULL, `nomeIngles` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '453d350186cb7c30f7bb72b94f046de1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `template`");
        _db.execSQL("DROP TABLE IF EXISTS `filmes`");
        _db.execSQL("DROP TABLE IF EXISTS `configuracoes`");
        _db.execSQL("DROP TABLE IF EXISTS `paismapping`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTemplate = new HashMap<String, TableInfo.Column>(4);
        _columnsTemplate.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTemplate.put("perguntaPrimeiraMetade", new TableInfo.Column("perguntaPrimeiraMetade", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTemplate.put("perguntaSegundaMetade", new TableInfo.Column("perguntaSegundaMetade", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTemplate.put("tipoDePergunta", new TableInfo.Column("tipoDePergunta", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTemplate = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTemplate = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTemplate = new TableInfo("template", _columnsTemplate, _foreignKeysTemplate, _indicesTemplate);
        final TableInfo _existingTemplate = TableInfo.read(_db, "template");
        if (! _infoTemplate.equals(_existingTemplate)) {
          return new RoomOpenHelper.ValidationResult(false, "template(com.example.projetointegrador.domain.Template).\n"
                  + " Expected:\n" + _infoTemplate + "\n"
                  + " Found:\n" + _existingTemplate);
        }
        final HashMap<String, TableInfo.Column> _columnsFilmes = new HashMap<String, TableInfo.Column>(5);
        _columnsFilmes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilmes.put("nome", new TableInfo.Column("nome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilmes.put("pais", new TableInfo.Column("pais", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilmes.put("dataLancamento", new TableInfo.Column("dataLancamento", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilmes.put("diretor", new TableInfo.Column("diretor", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFilmes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFilmes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFilmes = new TableInfo("filmes", _columnsFilmes, _foreignKeysFilmes, _indicesFilmes);
        final TableInfo _existingFilmes = TableInfo.read(_db, "filmes");
        if (! _infoFilmes.equals(_existingFilmes)) {
          return new RoomOpenHelper.ValidationResult(false, "filmes(com.example.projetointegrador.domain.FilmeReplace).\n"
                  + " Expected:\n" + _infoFilmes + "\n"
                  + " Found:\n" + _existingFilmes);
        }
        final HashMap<String, TableInfo.Column> _columnsConfiguracoes = new HashMap<String, TableInfo.Column>(4);
        _columnsConfiguracoes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfiguracoes.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfiguracoes.put("vibrar", new TableInfo.Column("vibrar", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsConfiguracoes.put("notificacoes", new TableInfo.Column("notificacoes", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysConfiguracoes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesConfiguracoes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoConfiguracoes = new TableInfo("configuracoes", _columnsConfiguracoes, _foreignKeysConfiguracoes, _indicesConfiguracoes);
        final TableInfo _existingConfiguracoes = TableInfo.read(_db, "configuracoes");
        if (! _infoConfiguracoes.equals(_existingConfiguracoes)) {
          return new RoomOpenHelper.ValidationResult(false, "configuracoes(com.example.projetointegrador.domain.Configuracoes).\n"
                  + " Expected:\n" + _infoConfiguracoes + "\n"
                  + " Found:\n" + _existingConfiguracoes);
        }
        final HashMap<String, TableInfo.Column> _columnsPaismapping = new HashMap<String, TableInfo.Column>(3);
        _columnsPaismapping.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaismapping.put("nomePortugues", new TableInfo.Column("nomePortugues", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPaismapping.put("nomeIngles", new TableInfo.Column("nomeIngles", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPaismapping = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPaismapping = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPaismapping = new TableInfo("paismapping", _columnsPaismapping, _foreignKeysPaismapping, _indicesPaismapping);
        final TableInfo _existingPaismapping = TableInfo.read(_db, "paismapping");
        if (! _infoPaismapping.equals(_existingPaismapping)) {
          return new RoomOpenHelper.ValidationResult(false, "paismapping(com.example.projetointegrador.domain.PaisMapping).\n"
                  + " Expected:\n" + _infoPaismapping + "\n"
                  + " Found:\n" + _existingPaismapping);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "453d350186cb7c30f7bb72b94f046de1", "42cbee7d490172c96fc012347fd2c0f7");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "template","filmes","configuracoes","paismapping");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `template`");
      _db.execSQL("DELETE FROM `filmes`");
      _db.execSQL("DELETE FROM `configuracoes`");
      _db.execSQL("DELETE FROM `paismapping`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public TemplateDAO TemplateDAO() {
    if (_templateDAO != null) {
      return _templateDAO;
    } else {
      synchronized(this) {
        if(_templateDAO == null) {
          _templateDAO = new TemplateDAO_Impl(this);
        }
        return _templateDAO;
      }
    }
  }

  @Override
  public FilmeReplaceDAO FilmeReplaceDAO() {
    if (_filmeReplaceDAO != null) {
      return _filmeReplaceDAO;
    } else {
      synchronized(this) {
        if(_filmeReplaceDAO == null) {
          _filmeReplaceDAO = new FilmeReplaceDAO_Impl(this);
        }
        return _filmeReplaceDAO;
      }
    }
  }

  @Override
  public ConfiguracoesDAO ConfiguracoesDAO() {
    if (_configuracoesDAO != null) {
      return _configuracoesDAO;
    } else {
      synchronized(this) {
        if(_configuracoesDAO == null) {
          _configuracoesDAO = new ConfiguracoesDAO_Impl(this);
        }
        return _configuracoesDAO;
      }
    }
  }

  @Override
  public PaisMappingDAO PaisMappingDAO() {
    if (_paisMappingDAO != null) {
      return _paisMappingDAO;
    } else {
      synchronized(this) {
        if(_paisMappingDAO == null) {
          _paisMappingDAO = new PaisMappingDAO_Impl(this);
        }
        return _paisMappingDAO;
      }
    }
  }
}
