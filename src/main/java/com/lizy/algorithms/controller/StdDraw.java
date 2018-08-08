package com.lizy.algorithms.controller;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author lizy@19pay.com.cn
 * @date 2018-8-8 20:08
 */
public class StdDraw implements ActionListener, MouseListener, MouseMotionListener, KeyListener {
    public static final Color BLACK = Color.BLACK;
    public static final Color BLUE = Color.BLUE;
    public static final Color CYAN = Color.CYAN;
    public static final Color DARK_GRAY = Color.DARK_GRAY;
    public static final Color GRAY = Color.GRAY;
    public static final Color GREEN = Color.GREEN;
    public static final Color LIGHT_GRAY = Color.LIGHT_GRAY;
    public static final Color MAGENTA = Color.MAGENTA;
    public static final Color ORANGE = Color.ORANGE;
    public static final Color PINK = Color.PINK;
    public static final Color RED = Color.RED;
    public static final Color WHITE = Color.WHITE;
    public static final Color YELLOW = Color.YELLOW;
    public static final Color BOOK_BLUE = new Color(9,90,166);
    public static final Color BOOK_LIGHT_BLUE = new Color(103,198,243);
    public static final Color BOOK_RED = new Color(150,35,31);
    public static final Color PRINCETON_ORANGE = new Color(245,128,37);
    public static final Color DEFAULT_PEN_COLOR = BLACK;
    public static final Color DEFAULT_CLEAR_COLOR = WHITE;
    private static Color penColor;
    private static final int DEFAULT_SIZE = 512;
    private static int width = DEFAULT_SIZE;
    private static int hight = DEFAULT_SIZE;
    private static final double DEFAULT_PEN_RADIUS = 0.002;
    private static double penRadius;

    private static final double BORDER = 0.00;
    private static final double DEFAULT_XMIN = 0.0;
    private static final double DEFAULT_XMAX = 1.0;
    private static final double DEFAULT_YMIN = 0.0;
    private static final double DEFAULT_YMAX = 1.0;
    private static double xmin, ymin, xmax, ymax;

    private static Object mouseLock = new Object();
    private static Object keyLock = new Object();

}
