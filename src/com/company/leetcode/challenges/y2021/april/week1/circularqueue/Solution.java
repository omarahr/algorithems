package com.company.leetcode.challenges.y2021.april.week1.circularqueue;

public class Solution {
    static class MyCircularQueue {
        int[] queue;
        int size, head;

        public MyCircularQueue(int k) {
            queue = new int[k];
            size = 0;
            head = 0;
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;


            int index = (head + size) % queue.length;
            queue[index] = value;

            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;

            head = (head + 1) % queue.length;
            size--;
            return true;
        }

        public int Front() {
            if (isEmpty())
                return -1;
            return queue[head];
        }

        public int Rear() {
            if (isEmpty())
                return -1;
            int index = (head + size - 1) % queue.length;
            return queue[index];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());

    }

}
