package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    @SneakyThrows
    private static Connection getConnection() {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");
    }

//    @SneakyThrows
//    private static Connection getConnection() {
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
//    }

    @SneakyThrows
    public static DataHelper.InfoPaymentDB getInfoPaymentCard() {
        var statusSQL = "SELECT * FROM payment_entity";
        var conn = getConnection();
        var status = runner.query(conn, statusSQL, new BeanHandler<>(DataHelper.InfoPaymentDB.class));
        return new DataHelper.InfoPaymentDB(status.getStatus(), status.getTransaction_id());
    }

    @SneakyThrows
    public static DataHelper.InfoCreditPurchaseDB getInfoPurchaseCreditCard() {
        var statusSQL = "SELECT * FROM credit_request_entity";
        var conn = getConnection();
        var creditStatus = runner.query(conn, statusSQL, new BeanHandler<>(DataHelper.InfoCreditPurchaseDB.class));
        return new DataHelper.InfoCreditPurchaseDB(creditStatus.getBank_id(), creditStatus.getStatus());
    }

    @SneakyThrows
    public static DataHelper.FixingPurchaseOrderMethod getFixOrderMethod() {
        var orderIDSQL = "SELECT * FROM order_entity";
        var conn = getConnection();
        var orderMethod = runner.query(conn, orderIDSQL, new BeanHandler<>(DataHelper.FixingPurchaseOrderMethod.class));
        return new DataHelper.FixingPurchaseOrderMethod(orderMethod.getCredit_id(), orderMethod.getPayment_id());
    }

    @SneakyThrows
    public static void cleanDB() {
        var connection = getConnection();
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM credit_request_entity");
        runner.execute(connection, "DELETE FROM order_entity");
    }
}

