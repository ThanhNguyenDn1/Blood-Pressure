package com.example.bloodpressure.utils

import com.example.bloodpressure.R

enum class KnowLedge {
    KNOWLEDGE_3, KNOWLEDGE_1, KNOWLEDGE_2, KNOWLEDGE_5, KNOWLEDGE_12, KNOWLEDGE_4, KNOWLEDGE_15, KNOWLEDGE_6, KNOWLEDGE_11, KNOWLEDGE_9, KNOWLEDGE_14, KNOWLEDGE_10, KNOWLEDGE_13, KNOWLEDGE_7, KNOWLEDGE_8, KNOWLEDGE_16, KNOWLEDGE_17, KNOWLEDGE_18, KNOWLEDGE_19, KNOWLEDGE_20, KNOWLEDGE_21, KNOWLEDGE_22, KNOWLEDGE_23, KNOWLEDGE_24, KNOWLEDGE_25, KNOWLEDGE_26, KNOWLEDGE_27;

/*    init {
        val iArr = IntArray(p246r2.C3808b.values().size)
        iArr[1] = 1
        iArr[2] = 2
        iArr[0] = 3
        iArr[5] = 4
        iArr[3] = 5
        iArr[7] = 6
        iArr[13] = 7
        iArr[14] = 8
        iArr[9] = 9
        iArr[11] = 10
        iArr[8] = 11
        iArr[4] = 12
        iArr[12] = 13
        iArr[10] = 14
        iArr[6] = 15
        iArr[15] = 16
        iArr[16] = 17
        iArr[17] = 18
        iArr[18] = 19
        iArr[19] = 20
        iArr[20] = 21
        iArr[21] = 22
        iArr[22] = 23
        iArr[23] = 24
        iArr[24] = 25
        iArr[25] = 26
        iArr[26] = 27
        f10359a = iArr
    }*/


    fun mo10948b(): String {
        return when (ordinal) {
            0 -> "87"
            1 -> "85"
            2 -> "86"
            3 -> "89"
            4 -> "96"
            5 -> "88"
            6 -> "99"
            7 -> "90"
            8 -> "95"
            9 -> "93"
            10 -> "98"
            11 -> "94"
            12 -> "97"
            13 -> "91"
            14 -> "92"
            15 -> "189"
            16 -> "167"
            17 -> "168"
            18 -> "169"
            19 -> "170"
            20 -> "171"
            21 -> "172"
            22 -> "173"
            23 -> "174"
            24 -> "175"
            25 -> "176"
            26 -> "177"
            else -> "177"
        }
    }

    /* renamed from: d */
    fun getColor(): Int {
        return when (ordinal) {
            0 -> R.color.knowledge_3
            1 -> R.color.knowledge_1
            2 -> R.color.knowledge_2
            3 -> R.color.knowledge_5
            4 -> R.color.knowledge_12
            5 -> R.color.knowledge_4
            4 -> R.color.knowledge_15
            7 -> R.color.knowledge_6
            8 -> R.color.knowledge_11
            9 -> R.color.knowledge_9
            10 -> R.color.knowledge_14
            11 -> R.color.knowledge_10
            12 -> R.color.knowledge_13
            13 -> R.color.knowledge_7
            14 -> R.color.knowledge_8
            15 -> R.color.knowledge_16
            16 -> R.color.knowledge_17
            17 -> R.color.knowledge_18
            18 -> R.color.knowledge_19
            19 -> R.color.knowledge_20
            20 -> R.color.knowledge_21
            21 -> R.color.knowledge_22
            22 -> R.color.knowledge_23
            23 -> R.color.knowledge_24
            24 -> R.color.knowledge_25
            25 -> R.color.knowledge_26
            26 -> R.color.knowledge_27
            else -> R.color.knowledge_27
        }
    }

    /* renamed from: e */
    /* fun mo10950e(): List<Int> {
         return when (ordinal) {
             0 -> C0014a.m46c(1, 4)
             1 -> C0014a.m46c(2, 4)
             2 -> C0014a.m46c(2, 4, 7, 9, 12, 15)
             3 -> C0014a.m46c(2, 5)
             4 -> C0014a.m46c(3, 5, 9)
             5 -> C0014a.m46c(2, 4, 7, 10, 12, 15, 17, 20, 22)
             DaoLog.ERROR -> C0014a.m46c(2, 4, 6, 9)
             7 -> C0014a.m46c(1, 3, 5, 7, 9, 11, 13)
             8 -> C0014a.m46c(2, 7, 13)
             9 -> C0014a.m46c(2, 8, 14, 20)
             10 -> C0014a.m46c(2, 4, 6, 9)
             ModuleDescriptor.MODULE_VERSION -> C0014a.m46c(2, 6, 10, 14, 18, 21)
             12 -> C0014a.m46c(2, 8, 14)
             13 -> C0014a.m46c(2, 6, 11, 14)
             ViewInfoStore.InfoRecord.FLAG_APPEAR_PRE_AND_POST -> C0014a.m46c(1, 3, 12)
             15 -> C0014a.m46c(2, 4, 6)
             16 -> C0014a.m46c(1, 6)
             17 -> C0014a.m46c(3, 5, 14, 16)
             18 -> C0014a.m46c(2, 4, 6, 8, 11)
             19 -> C0014a.m46c(2, 4, 6, 8, 10, 12, 14)
             20 -> C0014a.m46c(1, 3, 5, 7, 9)
             21 -> C0014a.m46c(2, 4, 6, 8, 10, 12, 14, 16, 18)
             22 -> C0014a.m46c(2, 4, 6, 8, 10)
             23 -> C0014a.m46c(1, 3)
             24 -> C0014a.m45b(2)
             25 -> C0014a.m46c(2, 27)
             26 -> C0014a.m45b(3)
             else -> throw C3056e()
         }
     }

     *//* renamed from: f *//*
    fun mo10951f(): Int {
        return if (mo10957l()) -16777216 else -1
    }
*/
    /* renamed from: g */
    fun getIcon(): Int {
        return when (ordinal) {
            0 -> R.drawable.img_info_s3
            1 -> R.drawable.img_info_s1
            2 -> R.drawable.img_info_s2
            3 -> R.drawable.img_info_s5
            4 -> R.drawable.img_info_s12
            5 -> R.drawable.img_info_s4
            6 -> R.drawable.img_info_s15
            7 -> R.drawable.img_info_s6
            8 -> R.drawable.img_info_s11
            9 -> R.drawable.img_info_s9
            10 -> R.drawable.img_info_s14
            11 -> R.drawable.img_info_s10
            12 -> R.drawable.img_info_s13
            13 -> R.drawable.img_info_s7
            14 -> R.drawable.img_info_s8
            15 -> R.drawable.img_info_s16
            16 -> R.drawable.img_info_s17
            17 -> R.drawable.img_info_s18
            18 -> R.drawable.img_info_s19
            19 -> R.drawable.img_info_s20
            20 -> R.drawable.img_info_s21
            21 -> R.drawable.img_info_s22
            22 -> R.drawable.img_info_s23
            23 -> R.drawable.img_info_s24
            24 -> R.drawable.img_info_s25
            25 -> R.drawable.img_info_s26
            26 -> R.drawable.img_info_s27
            else -> R.drawable.img_info_s27
        }
    }

    fun getTitle(): Int {
        return when (ordinal) {
            0 -> R.string.new_knowledge_3
            1 -> R.string.bp2_knowledge_2_a
            2 -> R.string.new_knowledge_1
            3 -> R.string.new_knowledge_5
            4 -> R.string.new_knowledge_12
            5 -> R.string.new_knowledge_4
            6 -> R.string.new_knowledge_15
            7 -> R.string.new_knowledge_6
            8 -> R.string.new_knowledge_11
            9 -> R.string.new_knowledge_9
            10 -> R.string.new_knowledge_14
            11 -> R.string.bp2_knowledge_10_a
            12 -> R.string.bp2_knowledge_13
            13 -> R.string.bp2_knowledge_7
            14 -> R.string.bp2_knowledge_8
            15 -> R.string.bp2_knowledge_16_a
            16 -> R.string.bp2_knowledge_17
            17 -> R.string.bp2_knowledge_18
            18 -> R.string.bp2_knowledge_19
            19 -> R.string.bp2_knowledge_20
            20 -> R.string.bp2_knowledge_21
            21 -> R.string.bp2_knowledge_22
            22 -> R.string.bp2_knowledge_23
            23 -> R.string.bp2_knowledge_24
            24 -> R.string.bp2_knowledge_25
            25 -> R.string.bp2_knowledge_26
            26 -> R.string.bp2_knowledge_27
            else -> R.string.bp2_knowledge_27
        }
    }
}