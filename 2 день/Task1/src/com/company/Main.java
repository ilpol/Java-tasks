package com.company;

public class Main {

    public static void main(String[] args) {
        // 1 задание
        Segment segmment1 = new Segment(1,1,2,2);
        Segment segmment2 = new Segment(1,1,2,2);
        if (segmment1.sameLength(segmment2))
            System.out.println(segmment1.getLength());
        System.out.println(segmment1.sameLength(segmment2));
        Segment segmment3 = new Segment(1,1,2,2);
        Segment segmment4 = new Segment(-3,0,1,1);
        if (segmment3.sameLength(segmment4))
            System.out.println(segmment3.sameLength(segmment4));

    }
}

class Segment {
    double firstDotX;
    double firstDotY;
    double lastDotX;
    double lastDotY;
    double eps = 0.0000001;
    
    Segment (double firstDotX,double firstDotY, double lastDotX, double lastDotY) {
        this.firstDotX = firstDotX;
        this.firstDotY = firstDotY;
        this.lastDotX = lastDotX;
        this.lastDotY = lastDotY;
    }


    public boolean sameLength(Object secondSegment) {

        if (secondSegment == this) {
            return true;
        }
        
        if (!(secondSegment instanceof Segment)) {
            return false;
        }

        Segment secondSegmentCasted = (Segment) secondSegment;

        return Math.abs(this.getLength() - secondSegmentCasted.getLength()) < eps;

    }

    public double getLength() {
        return Math.sqrt(Math.pow(this.lastDotX - this.firstDotX,2) + Math.pow(this.lastDotY - this.firstDotY,2));
    }
}