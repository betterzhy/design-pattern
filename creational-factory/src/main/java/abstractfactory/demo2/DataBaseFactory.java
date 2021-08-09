package abstractfactory.demo2;

// 数据库连接对象
abstract class IConn {
}

// 数据库原信息
abstract class IMeta {
}

class OracleConn extends IConn {
}

class OracleMeta extends IMeta {
}

class MysqlConn extends IConn {
}

class MysqlMeta extends IMeta {
}


class MysqlFactory extends DataBaseFactory {
    @Override
    public IConn getConn() {
        return new MysqlConn();
    }

    @Override
    public IMeta getMeta() {
        return new MysqlMeta();
    }
}

class OracleFactory extends DataBaseFactory {
    @Override
    public IConn getConn() {
        return new OracleConn();
    }

    @Override
    public IMeta getMeta() {
        return new OracleMeta();
    }
}

enum Vender {
    MYSQL, ORACLE
}

public abstract class DataBaseFactory {
    private static final MysqlFactory MYSQL_FACTORY = new MysqlFactory();
    private static final OracleFactory ORACLE_FACTORY = new OracleFactory();

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given vender.
    static DataBaseFactory getFactory(Vender vender) {
        DataBaseFactory factory = switch (vender) {
            case MYSQL -> MYSQL_FACTORY;
            case ORACLE -> ORACLE_FACTORY;
            default -> null;
        };
        return factory;
    }

    public abstract IConn getConn();

    public abstract IMeta getMeta();
}
