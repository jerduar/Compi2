/* Generated By:JavaCC: Do not edit this line. Analizador_LienzoTokenManager.java */
package AnalizadorCC;

/** Token Manager. */
public class Analizador_LienzoTokenManager implements Analizador_LienzoConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x7ffff9ffc00L) != 0L)
         {
            jjmatchedKind = 46;
            return 11;
         }
         if ((active0 & 0x102000000000000L) != 0L || (active1 & 0x400L) != 0L)
            return 18;
         return -1;
      case 1:
         if ((active0 & 0x3000L) != 0L)
            return 11;
         if ((active0 & 0x7ffff9fcc00L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 46;
               jjmatchedPos = 1;
            }
            return 11;
         }
         return -1;
      case 2:
         if ((active0 & 0x8000000L) != 0L)
            return 11;
         if ((active0 & 0x7fff79fec00L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 2;
            return 11;
         }
         return -1;
      case 3:
         if ((active0 & 0x7fbf7974400L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 3;
            return 11;
         }
         if ((active0 & 0x40008a800L) != 0L)
            return 11;
         return -1;
      case 4:
         if ((active0 & 0x7fb77924000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 4;
            return 11;
         }
         if ((active0 & 0x80050400L) != 0L)
            return 11;
         return -1;
      case 5:
         if ((active0 & 0x40030100000L) != 0L)
            return 11;
         if ((active0 & 0x3fb47824000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 5;
            return 11;
         }
         return -1;
      case 6:
         if ((active0 & 0x1fb46004000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 6;
            return 11;
         }
         if ((active0 & 0x20001820000L) != 0L)
            return 11;
         return -1;
      case 7:
         if ((active0 & 0x13202004000L) != 0L)
         {
            jjmatchedKind = 46;
            jjmatchedPos = 7;
            return 11;
         }
         if ((active0 & 0xc944000000L) != 0L)
            return 11;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 72;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x96L);
      case 36:
         return jjStopAtPos(0, 47);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x60L);
      case 40:
         return jjStopAtPos(0, 53);
      case 41:
         return jjStopAtPos(0, 54);
      case 42:
         return jjStopAtPos(0, 58);
      case 43:
         jjmatchedKind = 55;
         return jjMoveStringLiteralDfa1_0(0x1000000000000L, 0x800L);
      case 44:
         return jjStopAtPos(0, 52);
      case 45:
         jjmatchedKind = 56;
         return jjMoveStringLiteralDfa1_0(0x2000000000000L, 0x400L);
      case 47:
         return jjStopAtPos(0, 59);
      case 58:
         return jjStopAtPos(0, 73);
      case 59:
         return jjStopAtPos(0, 76);
      case 60:
         jjmatchedKind = 61;
         return jjMoveStringLiteralDfa1_0(0x4000000000000000L, 0x0L);
      case 61:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x1000000000000000L, 0x0L);
      case 62:
         jjmatchedKind = 63;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1L);
      case 63:
         return jjStopAtPos(0, 21);
      case 67:
         return jjMoveStringLiteralDfa1_0(0x1000000000L, 0x0L);
      case 76:
         return jjMoveStringLiteralDfa1_0(0x100000L, 0x0L);
      case 80:
         return jjMoveStringLiteralDfa1_0(0x1e000000000L, 0x0L);
      case 91:
         return jjStopAtPos(0, 44);
      case 93:
         return jjStopAtPos(0, 45);
      case 94:
         return jjStopAtPos(0, 57);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x20000000000L, 0x0L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x40000000L, 0x0L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x32000c000L, 0x0L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x80020000L, 0x0L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x14000000L, 0x0L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x400L, 0x0L);
      case 104:
         return jjMoveStringLiteralDfa1_0(0x40000L, 0x0L);
      case 109:
         return jjMoveStringLiteralDfa1_0(0x800000000L, 0x0L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x3880000L, 0x0L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x40000000000L, 0x0L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x13000L, 0x0L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x800L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x408000000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 50);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x8L);
      case 125:
         return jjStopAtPos(0, 51);
      case 191:
         return jjStopAtPos(0, 22);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0, long active1)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active1 & 0x40L) != 0L)
            return jjStopAtPos(1, 70);
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x84L);
      case 43:
         if ((active1 & 0x800L) != 0L)
            return jjStopAtPos(1, 75);
         break;
      case 45:
         if ((active1 & 0x400L) != 0L)
            return jjStopAtPos(1, 74);
         break;
      case 61:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 48);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStopAtPos(1, 49);
         else if ((active0 & 0x1000000000000000L) != 0L)
            return jjStopAtPos(1, 60);
         else if ((active0 & 0x4000000000000000L) != 0L)
            return jjStopAtPos(1, 62);
         else if ((active1 & 0x1L) != 0L)
            return jjStopAtPos(1, 64);
         else if ((active1 & 0x2L) != 0L)
            return jjStopAtPos(1, 65);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x1280d8400L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000020000L, active1, 0L);
      case 105:
         if ((active0 & 0x1000L) != 0L)
         {
            jjmatchedKind = 12;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x1c800102000L, active1, 0L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x10000000L, active1, 0L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x16c0004000L, active1, 0L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x22003000800L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x800000L, active1, 0L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000L, active1, 0L);
      case 124:
         if ((active1 & 0x8L) != 0L)
            return jjStopAtPos(1, 67);
         else if ((active1 & 0x20L) != 0L)
            return jjStopAtPos(1, 69);
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x10L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, active1);
      return 2;
   }
   switch(curChar)
   {
      case 38:
         if ((active1 & 0x80L) != 0L)
            return jjStopAtPos(2, 71);
         break;
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0x80800000L, active1, 0L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000L, active1, 0L);
      case 100:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000000L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x800100000L, active1, 0L);
      case 102:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L, active1, 0L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x2401000000L, active1, 0L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x10400L, active1, 0L);
      case 109:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L, active1, 0L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x1d200002000L, active1, 0L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x42000000L, active1, 0L);
      case 114:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(2, 27, 11);
         return jjMoveStringLiteralDfa3_0(active0, 0x20100080000L, active1, 0L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L, active1, 0L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x40014000000L, active1, 0L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x800L, active1, 0L);
      case 124:
         if ((active1 & 0x10L) != 0L)
            return jjStopAtPos(2, 68);
         break;
      case 161:
         if ((active1 & 0x4L) != 0L)
            return jjStopAtPos(2, 66);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, active1);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(1, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(3, 19, 11);
         return jjMoveStringLiteralDfa4_0(active0, 0x100000000L);
      case 100:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(3, 34, 11);
         break;
      case 101:
         if ((active0 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 11);
         return jjMoveStringLiteralDfa4_0(active0, 0x20030060000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x4010000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0xc0800000L);
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x2800100000L);
      case 111:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(3, 13, 11);
         else if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(3, 15, 11);
         break;
      case 112:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000400L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x1d002000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x40000000000L);
      case 118:
         return jjMoveStringLiteralDfa4_0(active0, 0x1000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x1c001000000L);
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x2100020000L);
      case 101:
         if ((active0 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 11);
         else if ((active0 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(4, 31, 11);
         return jjMoveStringLiteralDfa5_0(active0, 0x246000000L);
      case 103:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000800000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x20000000L);
      case 114:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(4, 16, 11);
         else if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(4, 18, 11);
         return jjMoveStringLiteralDfa5_0(active0, 0x40010004000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000000L);
      case 122:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 97:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(5, 29, 11);
         return jjMoveStringLiteralDfa6_0(active0, 0x40000000L);
      case 99:
         return jjMoveStringLiteralDfa6_0(active0, 0x800000L);
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x1000000L);
      case 103:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000L);
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000000L);
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x20000000000L);
      case 110:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 42, 11);
         return jjMoveStringLiteralDfa6_0(active0, 0x1004000000L);
      case 111:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(5, 20, 11);
         else if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(5, 28, 11);
         return jjMoveStringLiteralDfa6_0(active0, 0x4000L);
      case 114:
         return jjMoveStringLiteralDfa6_0(active0, 0x1ca00000000L);
      case 116:
         return jjMoveStringLiteralDfa6_0(active0, 0x100020000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 95:
         return jjMoveStringLiteralDfa7_0(active0, 0x1c000000000L);
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x800000000L);
      case 98:
         return jjMoveStringLiteralDfa7_0(active0, 0x4000L);
      case 100:
         return jjMoveStringLiteralDfa7_0(active0, 0x4000000L);
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x100000000L);
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000000L);
      case 110:
         return jjMoveStringLiteralDfa7_0(active0, 0x40000000L);
      case 111:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(6, 17, 11);
         else if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(6, 23, 11);
         else if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(6, 24, 11);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 41, 11);
         break;
      case 112:
         return jjMoveStringLiteralDfa7_0(active0, 0x2000000000L);
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x1000000000L);
      case 118:
         return jjMoveStringLiteralDfa7_0(active0, 0x200000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 79:
         return jjMoveStringLiteralDfa8_0(active0, 0x10000000000L);
      case 80:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 39, 11);
         break;
      case 83:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 38, 11);
         break;
      case 97:
         return jjMoveStringLiteralDfa8_0(active0, 0x3200004000L);
      case 100:
         return jjMoveStringLiteralDfa8_0(active0, 0x2000000L);
      case 101:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(7, 26, 11);
         break;
      case 111:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(7, 30, 11);
         break;
      case 114:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(7, 32, 11);
         break;
      case 115:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(7, 35, 11);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 82:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(8, 40, 11);
         break;
      case 108:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(8, 37, 11);
         break;
      case 111:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(8, 25, 11);
         break;
      case 114:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(8, 14, 11);
         else if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(8, 33, 11);
         else if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(8, 36, 11);
         break;
      default :
         break;
   }
   return jjStartNfa_0(7, active0, 0L);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 18;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                     jjCheckNAddStates(0, 2);
                  }
                  else if (curChar == 45)
                     jjCheckNAddTwoStates(13, 14);
                  else if (curChar == 39)
                     jjCheckNAddStates(3, 5);
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(14, 15);
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 6)
                        kind = 6;
                     jjCheckNAdd(13);
                  }
                  break;
               case 1:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(1, 2);
                  break;
               case 2:
                  if (curChar == 34 && kind > 8)
                     kind = 8;
                  break;
               case 3:
                  if (curChar == 39)
                     jjCheckNAddStates(3, 5);
                  break;
               case 4:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAdd(5);
                  break;
               case 5:
                  if (curChar == 39 && kind > 9)
                     kind = 9;
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 12:
                  if (curChar == 45)
                     jjCheckNAddTwoStates(13, 14);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAdd(13);
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(14, 15);
                  break;
               case 15:
                  if (curChar == 46)
                     jjCheckNAdd(16);
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 7)
                     kind = 7;
                  jjCheckNAdd(16);
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 6)
                     kind = 6;
                  jjCheckNAddStates(0, 2);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 11:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 46)
                     kind = 46;
                  jjCheckNAdd(11);
                  break;
               case 1:
                  jjAddStates(6, 7);
                  break;
               case 4:
                  jjCheckNAdd(5);
                  break;
               case 6:
                  if (curChar == 94)
                     jjAddStates(8, 10);
                  break;
               case 7:
                  if (curChar == 110)
                     jjCheckNAdd(5);
                  break;
               case 8:
                  if (curChar == 116)
                     jjCheckNAdd(5);
                  break;
               case 9:
                  if (curChar == 94)
                     jjCheckNAdd(5);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(6, 7);
                  break;
               case 4:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 18 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   13, 14, 15, 4, 5, 6, 1, 2, 7, 8, 9, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, 
"\146\141\154\163\145", "\164\162\165\145", "\163\151", "\163\151\156\157", 
"\143\157\155\160\162\157\142\141\162", "\143\141\163\157", "\163\141\154\151\162", "\144\145\146\145\143\164\157", 
"\150\141\143\145\162", "\160\141\162\141", "\114\151\145\156\172\157", "\77", "\277", 
"\160\165\142\154\151\143\157", "\160\162\151\166\141\144\157", "\160\162\157\164\145\147\151\144\157", 
"\145\170\164\151\145\156\144\145", "\166\141\162", "\145\156\164\145\162\157", "\143\141\144\145\156\141", 
"\142\157\157\154\145\141\156\157", "\144\157\142\154\145", "\143\141\162\141\143\164\145\162", 
"\143\157\156\163\145\162\166\141\162", "\166\157\151\144", "\155\151\145\156\164\162\141\163", 
"\103\157\156\164\151\156\165\141\162", "\120\162\151\156\143\151\160\141\154", "\120\151\156\164\141\162\137\123", 
"\120\151\156\164\141\162\137\120", "\120\151\156\164\141\162\137\117\122", "\141\162\162\145\147\154\157", 
"\162\145\164\165\162\156", "\75", "\133", "\135", null, "\44", "\53\75", "\55\75", "\173", "\175", "\54", 
"\50", "\51", "\53", "\55", "\136", "\52", "\57", "\75\75", "\74", "\74\75", "\76", 
"\76\75", "\41\75", "\41\46\241", "\174\174", "\41\174\174", "\46\174", "\46\46", 
"\41\46\46", "\41", "\72", "\55\55", "\53\53", "\73", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0xffffffffffffffc1L, 0x1fffL, 
};
static final long[] jjtoSkip = {
   0x1eL, 0x0L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[18];
private final int[] jjstateSet = new int[36];
protected char curChar;
/** Constructor. */
public Analizador_LienzoTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public Analizador_LienzoTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 18; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
