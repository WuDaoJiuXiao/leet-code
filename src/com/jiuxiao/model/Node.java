package com.jiuxiao.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据结构定义：图
 * @author: 悟道九霄
 * @date: 2023年05月08日 20:57
 * @version: 1.0.0
 */
public class Node {

    public int val;

    public List<Node> neighbors;

    public Node() {
        this.val = 0;
        this.neighbors = new ArrayList<Node>();
    }

    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<Node>();
    }

    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}