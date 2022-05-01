package org.wiselot.ArithTest.Driver;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.wiselot.ArithTest.Test.DriverInfo;

import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static final String DRIVER_NAME = "Driver";

    private long MessageCount;
    private long ErrorCount;
    private long WarnCount;

    private DriverInfo driverInfo;

    private void EventInit()
    {
        driverInfo = new DriverInfo(this);
        this.addListener(driverInfo);
    }

    public Driver(){
        EventInit();
    }

    public Driver(PrintStream printStream, InputStream inputStream){
        System.setIn(inputStream);
        System.setOut(printStream);
        System.setErr(printStream);
        EventInit();
    }
    public Driver(PrintStream printStream){
        System.setOut(printStream);
        System.setErr(printStream);
        EventInit();
    }
    public Driver(InputStream inputStream){
        System.setIn(inputStream);
    }

    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_ERROR = 1;
    public static final int TYPE_WARN = 2;

    @Contract(pure = true)
    private @NotNull String getDriverMessageSuffix(int type){
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        switch (type) {
            case TYPE_ERROR -> {
                return DRIVER_NAME + "[" + time + "]" +"[Error]:";
            }
            case TYPE_WARN -> {
                return DRIVER_NAME + "[" + time + "]" +"[Warn]:";
            }
            default -> {
                return DRIVER_NAME + "[" + time + "]" +"[Info]:";
            }
        }
    }

    public String getMessageText(int type,String text){
        return getDriverMessageSuffix(type) + text;
    }

    public void message(Object @NotNull ... prints){
        String msg;
        for(Object obj : prints){
            msg = getMessageText(TYPE_MESSAGE,obj.toString());
            System.out.println(msg);
            MessageCount++;
            sendMessageFlush(msg);
        }
    }

    public void error(Object @NotNull ... prints){
        String msg;
        for(Object obj : prints){
            msg = getMessageText(TYPE_ERROR,obj.toString());
            System.out.println(msg);
            ErrorCount++;
            sendMessageFlush(msg);
        }
    }
    public void warn(Object @NotNull ... prints){
        String msg;
        for(Object obj : prints) {
            msg = getMessageText(TYPE_WARN,obj.toString());
            System.out.println(msg);
            WarnCount++;
            sendMessageFlush(msg);
        }
    }

    private List listeners = new ArrayList();


    private void addListener(MessageInterFace messageInterFace){
        listeners.add(messageInterFace);
    }

    private void sendMessageFlush(String message){
        for(Object messageInterFace : listeners){
            if(messageInterFace instanceof MessageInterFace){
                ((MessageInterFace) messageInterFace).messageFlush(message);
            }
        }
    }

    public static class MessageEvent extends EventObject{

        /**
         * Constructs a prototypical Event.
         *
         * @param source the object on which the Event initially occurred
         * @throws IllegalArgumentException if source is null
         */
        public MessageEvent(Object source) {
            super(source);
        }
    }

    public interface MessageInterFace{
        void messageFlush(String message);
    }

    public long getMessageCount()
    {
        return MessageCount;
    }
    public long getErrorCount(){
        return ErrorCount;
    }
    public long getWarnCount(){
        return WarnCount;
    }
    public long getSumMessageCount(){
        return MessageCount + ErrorCount + WarnCount;
    }

    public interface InputInterface{
        ArrayList<String> getInput();
    }

    public void RunProgress(@NotNull Progress progress) throws Exception {
        progress.make(this);
        progress.display(this);
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        progress.check(this, str.split(","));
        progress.redisplay(this);
    }
}
