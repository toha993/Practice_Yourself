//package com.example.test1;
//
//import android.content.res.AssetManager;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Scanner;
//
//public class dataclass  {
//
//
//
//    private static Product[] addProduct(Product[] products, Product productToAdd) {
//        Product[] newProducts = new Product[products.length + 1];
//        System.arraycopy(products, 0, newProducts, 0, products.length);
//        newProducts[newProducts.length - 1] = productToAdd;
//
//        return newProducts;
//    }
//
//    public static class Product {
//        private String word;
//        private String op1;
//        private String op2;
//        private String op3;
//        private String op4;
//        private String correct;
//        private String chapter;
//
//        //private static NumberFormat formatter = new DecimalFormat("#0.00");
//
//        public Product(String n, String p, String d, String i, String s,String q,String cp) {
//            word = n;
//            correct=p ;
//            op1 = d;
//            op2 = i;
//            op3 = s;
//            op4 = q;
//            chapter=cp;
//        }
//
//        public String getWord() {
//            return word;
//        }
//
//        public void setWord(String word) {
//            this.word = word;
//        }
//
//        public String getOp1() {
//            return op1;
//        }
//
//        public void setOp1(String op1) {
//            this.op1 = op1;
//        }
//
//        public String getOp2() {
//            return op2;
//        }
//
//        public void setOp2(String op2) {
//            this.op2 = op2;
//        }
//
//        public String getOp3() {
//            return op3;
//        }
//
//        public void setOp3(String op3) {
//            this.op3 = op3;
//        }
//
//        public String getOp4() {
//            return op4;
//        }
//
//        public void setOp4(String op4) {
//            this.op4 = op4;
//        }
//
//        public String getCorrect() {
//            return correct;
//        }
//
//        public void setCorrect(String correct) {
//            this.correct = correct;
//        }
//
//        public String getChapter() {
//            return chapter;
//        }
//
//        public void setChapter(String chapter) {
//            this.chapter = chapter;
//        }
////        @Override
////        public String toString() {
////            return String.format("Word: %s\r\nOption1: %s\r\nOption2: %s\r\noption3: %s\r\noption4: %s\r\nCorrect: %s\r\nChapter: %s\r\n",
////                    word,op1,op2,op3,op4,correct,chapter);
////        }
//    }
//
//}
//
