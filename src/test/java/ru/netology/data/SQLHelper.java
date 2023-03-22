package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    @SneakyThrows
    private static Connection getConnection() {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "app", "pass");
    }

    public static DataHelper.PaymentStatus getPaymentStatusCard_1() {
        var statusSQL = "SELECT status FROM payment_entity";
        try (var conn = getConnection()) {
            var status = runner.query(conn, statusSQL, new ScalarHandler<String>());
            return new DataHelper.PaymentStatus(status);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static DataHelper.PaymentStatus getPaymentStatusCard_2() {
        var statusSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        try (var conn = getConnection()) {
            var status = runner.query(conn, statusSQL, new ScalarHandler<String>());
            return new DataHelper.PaymentStatus(status);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static DataHelper.PaymentCreditStatus getPaymentCreditStatusCard_1() {
        var statusSQL = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        try (var conn = getConnection()) {
            var creditStatus = runner.query(conn, statusSQL, new ScalarHandler<String>());
            return new DataHelper.PaymentCreditStatus(creditStatus);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static DataHelper.PaymentCreditStatus getPaymentCreditStatusCard_2() {
        var statusSQL = "SELECT status FROM credit_request_entity";
        try (var conn = getConnection()) {
            var creditStatus = runner.query(conn, statusSQL, new ScalarHandler<String>());
            return new DataHelper.PaymentCreditStatus(creditStatus);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static DataHelper.FixingPurchaseOrderMethod getFixOrderMethod() {
        var orderIDSQL = "SELECT payment_id FROM order_entity ORDER BY created DESC LIMIT 3";
        try (var conn = getConnection()) {
            var orderMethod = runner.query(conn,  orderIDSQL, new ScalarHandler<String>());
            return new DataHelper.FixingPurchaseOrderMethod(orderMethod);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static DataHelper.FixingPurchaseMethod getFixMethodPayment() {
        var idSQL = "SELECT transaction_id FROM payment_entity ORDER BY created DESC LIMIT 2";
        try (var conn = getConnection()) {
            var payment_id = runner.query(conn, idSQL, new ScalarHandler<String>());
            return new DataHelper.FixingPurchaseMethod(payment_id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static DataHelper.FixingPurchaseCreditMethod getFixMethodPaymentCredit() {
        var idCreditSQL = "SELECT bank_id FROM credit_request_entity";
        try (var conn = getConnection()) {
            var credit_id = runner.query(conn, idCreditSQL, new ScalarHandler<String>());
            return new DataHelper.FixingPurchaseCreditMethod(credit_id);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static DataHelper.FixingPurchaseOrderMethod getFixOrderMethodCredit() {
        var orderIDSQL = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 4";
        try (var conn = getConnection()) {
            var orderMethod = runner.query(conn,  orderIDSQL, new ScalarHandler<String>());
            return new DataHelper.FixingPurchaseOrderMethod(orderMethod);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

//    @SneakyThrows
//    public static void cleanDB() {
//        var connection = getConnection();
//        runner.execute(connection, "DELETE FROM payment_entity");
//        runner.execute(connection, "DELETE FROM credit_request_entity");
//        runner.execute(connection, "DELETE FROM order_entity");
//    }
}

