package com.company.datastructure.stack;

/**
 * 堆栈的应用
 * Created by daishuli on 2018/4/12.
 */
public class StackApplication {
    public static void main(String[] args) throws Exception {
        System.out.println("进制转换：");
        baseConversion(2007);
        System.out.println("括号匹配检测：{[()]}");
        System.out.println(bracketMatch("{[(}"));
    }

    /**
     * 进制转换
     * 十进制转八进制
     */
    public static void baseConversion(int param) {
        ArrayStack stack = new ArrayStack();
        while (param != 0) {
            stack.push(param % 8);
            param = param / 8;
        }
        stack.print();
    }

    /**
     * 括号匹配检测问题
     */
    public static boolean bracketMatch(String string) throws StackEmptyException {
        ArrayStack stack = new ArrayStack();
        if (string == null || string == "")
            return false;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':stack.push(Integer.valueOf(c));break;
                case ')':
                    if (!stack.isEmpty() && '(' == ((Integer)stack.pop()).intValue())
                        break;
                    else return false;
                case ']':
                    if (!stack.isEmpty() && '[' == ((Integer)stack.pop()).intValue())
                        break;
                    else return false;
                case '}':
                    if (!stack.isEmpty() && '{' == ((Integer)stack.pop()).intValue())
                        break;
                    else return false;

            }
        }
        if (stack.isEmpty())
            return true;
        else return false;
    }

    /**
     * 迷宫求解问题
     *
     */
    public static void mazeExit(char[][] maze, int beginX, int beginY, int endX, int endY) throws Exception {
        ArrayStack stack = new ArrayStack();
        Cell[][] cells = arrayToCell(maze);
        Cell begin = new Cell(beginX, beginY, '*', false);
        Cell end = new Cell(endX, endY,'*',false);
        // 将起始位置入栈
        stack.push(begin);
        begin.setVisitable(true);
        while (!stack.isEmpty()) {
            // 取出栈顶数据，判断是否为结束位置
            Cell temp = (Cell) stack.peek();
            if (temp.equals(end)) {
                // 当前位置即结束位置，打印路径
                stack.print();
            } else {
                int x = temp.getX()-1;
                int y = temp.getY();
                // 按照下右上左顺序判断是否可以访问，如果可以，进栈
                if (isOutBounding(cells, x, y)) {
                    stack.push(new Cell(x, y,'*', true));
                }
                x = temp.getX();
                y = temp.getY()+1;
                if (isOutBounding(cells, x, y)) {
                    stack.push(new Cell(x, y,'*', true));
                }
                x = temp.getX()+1;
                y = temp.getY();
                if (isOutBounding(cells, x, y)) {
                    stack.push(new Cell(x, y,'*', true));
                }
                x = temp.getX();
                y = temp.getY()-1;
                if (isOutBounding(cells, x, y)) {
                    stack.push(new Cell(x, y,'*', false));
                }
                if (temp.equals(stack.peek())){
                    stack.pop();
                }
            }
        }
    }

    private static Cell[][] arrayToCell(char[][] array) {
        Cell[][] cells = new Cell[array.length][];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                cells[i][j] = new Cell(i, j, array[i][j], false);
            }
        }
        return cells;
    }

    private static boolean isOutBounding(Cell[][] array, int x, int y) {
        try {
            if (array[x][y].getC() == '0' && !array[x][y].isVisitable())
                return true;
            else return false;
        } catch (Exception e){
            return false;
        }
    }

}

class Cell {
    private int x;
    private int y;
    private char c;
    private boolean visited; // true 已访问过，false 未访问
    public Cell(int x, int y, char c, boolean visited) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public char getC() {
        return c;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isVisitable() {
        return visited;
    }

    public void setVisitable(boolean visitable) {
        this.visited = visitable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (x != cell.x) return false;
        if (y != cell.y) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Cell{" + "x=" + x + ", y=" + y + "}";
    }
}
