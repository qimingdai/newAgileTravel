package agiletravel.dai.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.*;


class usertest {
    private String name;
    private int age;
    private String sex;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "usertest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

class test{
    public static void main(String[] args){
        SimpleList<String> stringSimpleList = new SimpleList<>();
        for(int i=0;i<26;i++){
            stringSimpleList.add("test"+i);
        }
        stringSimpleList.remove("test2");
        stringSimpleList.remove("test5");
        for(int i=0;i<stringSimpleList.size();i++){
            System.out.println(stringSimpleList.get(i));
        }

        System.out.println(stringSimpleList.size());
    }


}

class SimpleList<T>{
    private Object[] elementData;
    private int size=0;

    public int size(){
        return size;
    }
    public SimpleList(){
        elementData = new Object[5];
    }

    public boolean isEmplty(){
        if(size==0){
            return true;
        }else
            return false;
    }
    public boolean add(T e){
        if(elementData.length ==size){
            Object[] elementDataCopy = new Object[size*2];
            for(int i=0;i<elementData.length;i++){
                elementDataCopy[i]=elementData[i];
            }
            elementDataCopy[size]=e;
            elementData=elementDataCopy;
        }else {
            elementData[size]=e;
        }
        size++;
        return true;
    }
    public boolean remove(Object o){
        for(int i=0;i<elementData.length;i++){
            if(elementData[i].equals(o)){
                for(int j=i;j<elementData.length-1;j++){
                    elementData[j]=elementData[j+1];
                }
                size--;
                break;
            }
        }
        return true;
    }
    public T get(int index){
        return (T) elementData[index];
    }
}

