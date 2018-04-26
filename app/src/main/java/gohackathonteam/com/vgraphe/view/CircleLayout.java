package gohackathonteam.com.vgraphe.view;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CircleLayout extends ViewGroup {
    Point center;
    int radius;
    int parentWidth;
    int parentHeight;
    final int MAX_CHILD_SIZE = 120;
    final int MIN_CHILD_SIZE = 50;
    final int MAX_INNER_CIRCLE = 16;
    int childSize;

    public CircleLayout(Context context){
        super(context, null, 0);
        init(context);
    }

    public CircleLayout (Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init(context);
    }

    public CircleLayout (Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        childSize = MAX_CHILD_SIZE;
        center = new Point();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;

        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();

        center.set(parentWidth / 2, parentHeight / 2);

        //ATTENTION! High concentration of govnocode. Be careful here

        if (count <= MAX_INNER_CIRCLE) {
            double angle = 2 * Math.PI / count;
            double curAngle = 0.0;
            radius = parentWidth / 4;

            double dist = Math.sqrt(2 * Math.pow(radius, 2) * (1 - Math.cos(angle)));
            if (angle != 2 * Math.PI && dist < childSize) {
                if (dist < MIN_CHILD_SIZE) {
                    childSize = MIN_CHILD_SIZE;
                } else {
                    childSize = (int)dist - 20;
                }
            }

            for (int i = 0; i < count; i++) {
                View child = getChildAt(i);
                int offset = childSize / 2;
                int x = center.x - offset + (int)(radius * Math.sin(curAngle));
                int y = center.y + offset - (int)(radius * Math.cos(curAngle));
                child.layout(x, y - childSize, x + childSize, y);
                curAngle += angle;
            }
        } else {
            //Inner circle
            double angle1 = 2 * Math.PI / MAX_INNER_CIRCLE;
            double curAngle = 0.0;
            radius = parentWidth / 4;

            double dist = Math.sqrt(2 * Math.pow(radius, 2) * (1 - Math.cos(angle1)));
            if (dist < childSize) {
                if (dist < MIN_CHILD_SIZE) {
                    childSize = MIN_CHILD_SIZE;
                } else {
                    childSize = (int)dist - 20;
                }
            }

            for (int i = 0; i < MAX_INNER_CIRCLE; i++) {
                View child = getChildAt(i);
                int offset = childSize / 2;
                int x = center.x - offset + (int)(radius * Math.sin(curAngle));
                int y = center.y + offset - (int)(radius * Math.cos(curAngle));
                child.layout(x, y - childSize, x + childSize, y);
                curAngle += angle1;
            }

            //Outer Circle
            double angle2 = 2 * Math.PI / (count - MAX_INNER_CIRCLE);
            curAngle = 0.0;

            dist = Math.sqrt(2 * Math.pow(radius, 2) * (1 - Math.cos(angle2)));
            if (angle2 != 2 * Math.PI && dist < childSize) {
                if (dist < MIN_CHILD_SIZE) {
                    childSize = MIN_CHILD_SIZE;
                } else {
                    childSize = (int)dist;
                }
            }

            radius = parentWidth / 3;
            for (int i = MAX_INNER_CIRCLE; i < count; i++) {
                View child = getChildAt(i);
                int offset = childSize / 2;
                int x = center.x - offset + (int)(radius * Math.sin(curAngle));
                int y = center.y + offset - (int)(radius * Math.cos(curAngle));
                child.layout(x, y - childSize, x + childSize, y);
                curAngle += angle2;
            }
        }

    }



}
