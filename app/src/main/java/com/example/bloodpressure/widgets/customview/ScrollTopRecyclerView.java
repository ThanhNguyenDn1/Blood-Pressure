package com.example.bloodpressure.widgets.customview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashMap;

//import p001a0.C0011e;

public final class ScrollTopRecyclerView extends RecyclerView {

    /* renamed from: t */
    public boolean f2808t;

    /* renamed from: w */
    public int f2809w = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollTopRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
      //  C0011e.m12j(context, "context");
        new LinkedHashMap();
    }

    /* renamed from: a */
    public final void mo4016a(int i) {
        int childLayoutPosition = getChildLayoutPosition(getChildAt(0));
        boolean z = true;
        int childLayoutPosition2 = getChildLayoutPosition(getChildAt(getChildCount() - 1));
        if (i < childLayoutPosition) {
            smoothScrollToPosition(i);
        } else if (i <= childLayoutPosition2) {
            int i2 = i - childLayoutPosition;
            if (i2 < 0 || i2 >= getChildCount()) {
                z = false;
            }
            if (z) {
                smoothScrollBy(0, getChildAt(i2).getTop());
            }
        } else {
            smoothScrollToPosition(i);
            this.f2808t = true;
            this.f2809w = i;
        }
    }

    public final int getLastScrollPos() {
        return this.f2809w;
    }

    public final boolean getNeedScroll() {
        return this.f2808t;
    }

    public void onScrollStateChanged(int i) {
        int i2;
        super.onScrollStateChanged(i);
        if (this.f2808t && (i2 = this.f2809w) != -1 && i == 0) {
            mo4016a(i2);
            this.f2808t = false;
            this.f2809w = -1;
        }
    }

    public final void setLastScrollPos(int i) {
        this.f2809w = i;
    }

    public final void setNeedScroll(boolean z) {
        this.f2808t = z;
    }
}
