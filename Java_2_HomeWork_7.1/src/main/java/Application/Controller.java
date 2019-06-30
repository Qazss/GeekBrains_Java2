package Application;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public class Controller {
    @FXML
    TextField studentLogin;

    @FXML
    TextField studentName;

    @FXML
    TextField path;

    @FXML
    TextArea mainWindow;

    @FXML
    TextArea studentWindow;

    static ArrayList<Class> homeWorks;
    static HashMap<String, String> studentList;

    public void initStudents(){
        studentList = new HashMap<>();
        try {
            ResultSet resultSet = AuthService.getStudentsList();

            while (resultSet.next()){
                studentList.put(resultSet.getString(1), resultSet.getString(2));
                studentWindow.appendText(resultSet.getString(2) + "\n");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Ошибка при получении списка студентов");
        }
    }

    public void addStudent(){
        try {
            AuthService.connect();

            if(!studentLogin.getText().isEmpty() && !studentName.getText().isEmpty()) {
                AuthService.addStudent(studentLogin.getText(), studentName.getText());
                clearStudentRegisterFields();
            } else {
                JOptionPane.showMessageDialog(null,"Введите логин и ФИО студента");
                clearStudentRegisterFields();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Некорректно введен логин или ФИО");
            clearStudentRegisterFields();
        }
    }

    public void clearStudentRegisterFields(){
        studentName.setText("");
        studentLogin.setText("");
    }

    public void execute() {
        clearMainWindow();

        try {
            AuthService.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        initStudents();
        homeWorks = new ArrayList<>();
        String folderPath = "";

        if(!path.getText().isEmpty()){
            folderPath = path.getText();
        } else {
            JOptionPane.showMessageDialog(null,"Путь к папке не может быть пустым");
        }

        for (String login : studentList.keySet()) {
            try {
                homeWorks.add(URLClassLoader.newInstance(new URL[]{new File(folderPath).toURL()}).loadClass(login));
            } catch (ClassNotFoundException e) {
                mainWindow.appendText("Студент " + studentList.get(login) + " работу не сдал \n");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        mainWindow.appendText("----------------------------------------- \n");

        for (Class homeWork : homeWorks) {
            try {
                mainWindow.appendText("Студент: " + studentList.get(homeWork.getName()) + "\n");
                Method calculateInt = homeWork.getDeclaredMethod("calculate", int.class, int.class, int.class, int.class);
                calculateInt.setAccessible(true);
                Object m = calculateInt.invoke(homeWork, 1, 3, 4, 5);
                mainWindow.appendText(calculateInt.invoke(homeWork, 1, 3, 4, 5).toString() + "\n");

                Method calculateDbl = homeWork.getDeclaredMethod("calculate", float.class, float.class, float.class, float.class);
                calculateDbl.setAccessible(true);
                mainWindow.appendText(calculateDbl.invoke(homeWork, 1.2f, 2.4f, 1.5f, 5.7f).toString() + "\n");

                Method checkTwoNumbers = homeWork.getDeclaredMethod("checkTwoNumbers", int.class, int.class);
                checkTwoNumbers.setAccessible(true);
                mainWindow.appendText(checkTwoNumbers.invoke(homeWork, 2, 5).toString() + "\n");

                Method printIsPositive = homeWork.getDeclaredMethod("printIsPositive", int.class);
                printIsPositive.setAccessible(true);
                //printIsPositive.invoke(homeWork, 2);
                //mainWindow.appendText(isPositive + "\n");

                Method isNegative = homeWork.getDeclaredMethod("isNegative", int.class);
                isNegative.setAccessible(true);
                mainWindow.appendText(isNegative.invoke(homeWork, 5).toString() + "\n");

                Method printWelocome = homeWork.getDeclaredMethod("printWelocome", String.class);
                printWelocome.setAccessible(true);
                //printIsPositive.invoke(homeWork, "Sasha");
                //mainWindow.appendText(welcome + "\n");

                Method isLeapYear = homeWork.getDeclaredMethod("isLeapYear", int.class);
                isLeapYear.setAccessible(true);
                mainWindow.appendText(isLeapYear.invoke(homeWork, 5).toString() + "\n");
                mainWindow.appendText("----------------------------------------- \n");

            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void clearMainWindow(){
        mainWindow.clear();
        studentWindow.clear();
    }
}

