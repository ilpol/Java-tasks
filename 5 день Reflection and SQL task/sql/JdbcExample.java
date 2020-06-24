package com.pflb.learning.day5.sql;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class JdbcExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String url = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
        String userName = "fill in your username";
        String password = "fill in your password";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(url, userName, password);
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM country LIMIT ?");
        statement.setInt(1, 20);
        ResultSet resultSet = statement.executeQuery();
        statement.setInt(1, 25);
        ResultSet resultSet2 = statement.executeQuery();
        while (resultSet2.next()) {
//            System.out.printf("code: %s, name: %s\n", resultSet2.getString("code"), resultSet2.getString("name"));
            Country country = mapToObj(Country.class, resultSet2);
            System.out.printf("code: %s, name: %s\n", country.code, country.name);

        }

        PreparedStatement statementCity = connection.prepareStatement("SELECT * FROM city LIMIT ?");
        statementCity.setInt(1, 25);
        ResultSet resultSetCity = statementCity.executeQuery();
        while (resultSetCity.next()) {
            City city = mapToObj(City.class, resultSetCity);
            System.out.printf("id: %s, name: %s\n", city.id, city.name);
        }

        PreparedStatement statementCL = connection.prepareStatement("SELECT * FROM countrylanguage LIMIT ?");
        statementCL.setInt(1, 25);
        ResultSet resultSetCL = statementCL.executeQuery();
        while (resultSetCL.next()) {
            Countrylanguage countrylanguage = mapToObj(Countrylanguage.class, resultSetCL);
            System.out.printf("countrycode: %s, language: %s\n", countrylanguage.countrycode, countrylanguage.language);
        }
        resultSet2.close();
        statement.close();
        connection.close();
    }


    public static <T extends Entity> T mapToObj(Class<T> klass, ResultSet resultSet) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, SQLException {
        List<Field> fields = List.of(klass.getFields()).stream().filter(f -> f.isAnnotationPresent(Column.class)).collect(Collectors.toList());
        Constructor<T> constructor = klass.getDeclaredConstructor();
        T t = constructor.newInstance();
        for (Field field : fields) {
            field.setAccessible(true);
            Column columnAnnotation = field.getDeclaredAnnotation(Column.class);
            String columnName = columnAnnotation.name();
            String string = resultSet.getString(columnName);
            field.set(t, string);
        }
        return t;
    }



}
