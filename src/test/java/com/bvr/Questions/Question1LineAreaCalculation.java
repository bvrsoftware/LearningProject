package com.bvr.Questions;

import com.bvr.jts.helper.JTSVisualisationPanel;
import com.bvr.helper.Loging;
import com.tb.core.enums.DistanceUnit;
import com.tb.core.util.CoreUtil;
import org.geotools.geometry.jts.JTSFactoryFinder;
import org.geotools.referencing.CRS;
import org.geotools.util.factory.Hints;
import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.locationtech.jts.operation.buffer.BufferOp;
import org.locationtech.jts.operation.buffer.BufferParameters;
import org.locationtech.jts.util.GeometricShapeFactory;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.PathIterator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question1LineAreaCalculation {
    private static final Loging log = Loging.getInstance(Question1LineAreaCalculation.class);

    public static void main(String[] args) throws FactoryException, ParseException {
        List<Double[]> locations = new ArrayList<>();
        locations.add(new Double[]{77.342278, 28.604123});
        locations.add(new Double[]{77.342249, 28.604292});
        locations.add(new Double[]{77.342221, 28.604452});
        locations.add(new Double[]{77.342198, 28.604591});
        locations.add(new Double[]{77.342192, 28.604577});
        locations.add(new Double[]{77.342176, 28.604745});
        locations.add(new Double[]{77.342161, 28.604879});
        locations.add(new Double[]{77.342136, 28.605012});
        locations.add(new Double[]{77.342125, 28.605130});
        locations.add(new Double[]{77.342104, 28.605214});
//        locations.add(new Double[]{77.341956, 28.605184});
        String encodePath = "aazpCiaffOs@?O?oAAg@IMBC@GDCDAHOdAIhA}@`Dc@zA]rB@NBJDLHFDAD@HAB?BABCBG?EBMBI?CAC?CCACAE?E?GBA@JELMOh@ADEDEDC?E?GACACCCCEIAKDc@Fq@Bu@HW~@yBXg@Lk@Du@F}@No@DGFCDCH?D@NDHB\\B~@Fh@Df@EFCDERWLKBCPa@Vo@HIFGH?VCJKDI??";
//        calculateArea(LineUtils.decodePolyline(encodePath, null), 10);
//        calculateArea(locations, 10);
//        String point1WKT = "POINT(28.604123 77.342278)";
//        String point2WKT = "POINT(28.605214 77.342104)";
//
        Coordinate coordinate1 = new Coordinate(52.52615018586875,13.379035592079164);
        Coordinate coordinate2 = new Coordinate(52.52793993431555,13.378741936994667);
//
//        WKTReader reader = new WKTReader();
//        Point p1 = (Point) reader.read(point1WKT);
//        Point p2 = (Point) reader.read(point2WKT);
//
//        double distanceInMeters = p1.distance(p2);
        double distance = coordinate1.distance(coordinate2);
//        System.out.println(CoreUtil.calculateDistance(28.605214,77.342104,28.604123,77.342278,DistanceUnit.METER));
//        System.out.println("Distance between points in meters: " + distanceInMeters);
        System.out.println("Distance between coordinate in meters: " + distance);
        String csvFile = "/home/admin1/Downloads/output.csv"; // Replace with your actual CSV file path
        String line;
       List<Double[]> locs=new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // Process each line
                String[] locS = line.split(",");
                locs.add(new Double[]{Double.parseDouble(locS[1]),Double.parseDouble(locS[0])});
            }
//            calculateArea(locs,10);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test1(JTSVisualisationPanel panel, GeometryFactory geometryFactory) {
        List<Double[]> locations = new ArrayList<>();
        locations.add(new Double[]{28.604123, 77.342278});
        locations.add(new Double[]{28.604292, 77.342249});
        locations.add(new Double[]{28.604452, 77.342221});
        locations.add(new Double[]{28.604591, 77.342198});
        locations.add(new Double[]{28.604577, 77.342192});
        locations.add(new Double[]{28.604745, 77.342176});
        locations.add(new Double[]{28.604879, 77.342161});
        locations.add(new Double[]{28.605012, 77.342136});
        locations.add(new Double[]{28.605130, 77.342125});
        locations.add(new Double[]{28.605214, 77.342104});
        locations.add(new Double[]{28.605184, 77.341956});

//        String encodePath = "smrmD_aitM??@Ah@Jn@?J@??LBH@IPC?eAa@q@@C@??@@??AA?B?F??F?XA?HIx@]KJFBL????DB??@MZc@??V]UYUB@@????@?????DA??k@PKECMD]???B?BIDKU@CBYDS@QN[JCbCe@lD[bC[n@I^EvAOtDc@|DY|Dc@|Da@zD]b@AvCY|D_@jBQHe@Aq@C}EE}EGgDG}CEuEk@uEi@uEc@uE_@wE_@sE_@uE[{Ec@sEi@gFIi@WkDi@qE[cDMsBMqB_@qEQmBGaAOuB]wE_@yE_@gFa@wEk@uEaAkE}@mEy@mE}@oE{@oE??}@mE_AmE_AmEeAkEGU??YmAKe@Ww@GyCMyEs@qEmA_FoBoDsBqDgBuDq@}Ai@aBq@sEYeCGy@QmBCU??CUCS??CS??WoBY_DYcAYk@??KUCQ???EAICc@???{B?Q??T_Bd@qBJYHQ^cAFO??FS??FSDSFS????ReCCWiAkCKW??Os@EwAEmB????AmBIyB??@s@EuDCo@EgA??@k@ASAmBCk@AQCg@GeAGoAG}BMeD@]?KCyAKyEGaC??AWEaAAUIcEASMaDG}AMkCA}@@s@AMGuB???SMaC???S??C_A??E}AASAQASMaCS_AEQAKW{A??CSCSQeAQcAa@cCWyA[eBKaAKg@UiAw@gEk@sDa@{BW}Ae@iEQwEAOOsBSkBe@_BsAiALH[WkBcBOQ_@[QWu@aAy@s@eAmAg@[@?e@q@??IIkByB??yB_CqCmCqBiBIK{BkBuCgCwCmCsCeCwCeCoCeCMM{BaCgC{C{AqBe@q@_CaDeC}Cg@q@q@}@????Y]JNKOY_@w@_AmA_BiBoCMMLLcCuDm@iAaAgBkBcDyAqBCGIKo@gAi@u@WYkAiASU@?}@kA{AeB??GKy@y@c@e@??s@u@GGoBoBmC{CkCuCc@a@YYY]cCkCgCqCaCmCkCuCiCsCaCcDwBqCMO????yBsDyBeDu@mA??GMS]{AuCEKUgAcAaE]{@mA_C}AcDgAgBcAmBQUOYu@}AOYc@o@OYiBuDa@y@IS]u@GSQg@GS??ISeAwCc@eAGQq@}AQe@????kAsC[{@gA_CkBsDaAoBk@iAmBsDiBsDuBeE_@s@Sm@sAqDIQ??e@mAQe@]y@qA_DEK??Qe@aA{BwAmDISwA_EiAsDIQa@mA??Qe@Qg@Qe@Qe@Y{@e@wASw@[}@CIIKq@mBi@}Ac@qACQ{@}CoAgESe@qAiBMOc@u@uAcB[]uCkDKO[]oA{B{BsDwBoDyBmD_C}CsBoDa@w@_AmBgAwB?AKUq@aBDJ??eA_CISKQqBoD_AsAeAqAk@o@JLKMo@_AEIYYU]}AqAKKMK??]YNL??OMsAs@????]S??MI??o@_@????OGs@a@a@Sy@i@DDKKUMKGc@]UQuAu@IE}AuA??}BkBm@g@NLOMNL}@u@??kAcA_@Y????]WNJOK??k@i@[UGGQMFF??]_@OMc@[IC}AqA][??cCkBuCyBa@[y@{@??IIYU??oAgA[UKG]]e@]_A}@??MQeBaB{AiAaAw@][SS??{@{@????KK_AgA????GIOMy@u@WU[_@]]eAcAmAgAm@o@??OOUY{@u@IE??EGm@a@??YWuA{@_Ay@OKo@_@m@YHDUMJFYOm@MYIECU[OsBIyEGsEBgELsDL_CFm@VcE@uAJ_B?k@TiDBk@XoDRiBF{AJy@Dw@H_CHoBHcCFiC?QHaFVmEJqAFwBTeD`@sEb@cFNmC`@iENeELaEJwBAg@?UIaAWuA`@kCFmB@CAEJ_@XiARcBLc@DONyANwBFa@CYRmDPyEPyDZmCB}@JuA^sEHmEp@aDGwCZyBAMAs@H_@ZyC\\\\aFTmEVgEf@qENwBFUC{BDgECk@Bc@b@yCPeBJm@`@}C^sE^wEXwEXcDPcA@_@?u@XqEb@yEPkD@k@NeCZyEVuER}C?e@B]@w@??@YJ_BZgCD_DUwCnHi@FyB^sEn@{CO}C]]?uCe@iE[kDJaETqHB?^yM`A_E@UCcB@m@LkDb@aFP{EZuEVoF^aE^kFj@{EToDE[LyAAGGEICCCA?AC??Hi@PoAI{AzAaEB}A@b@A_AFWGV??`@gCJcAR}Bh@mE??^mCbAsDrA_EjAwDt@{Cr@iCr@iBl@kAFO`AeCvAiEj@_Bd@}AXw@??Xw@????`@kALg@t@eCDQx@mD??V}D??@SLmB??Hq@z@kDdBgDN_@\\\\m@DKXk@Pc@X{@HQLc@BO??`@mABS??d@gBFe@??Hg@??Dc@Fy@@OFW??@QFk@??NkCJ}A?CB[LgCXaCtAqCnAyAlAgANKDIDK??HI????FMVq@VyADM??DO??Jq@R}@J_@f@gA@ERm@Jg@`@qBhAmF`A{EfA_Ep@_Dj@sBx@_DFg@|@uDlAqDTs@X_Al@gARe@l@oBN_@jAgCz@cBFMDKt@_Bv@mBpAaDv@aCHUT_@f@uAB_@l@_Av@oBx@}At@}Av@_BXs@\\\\gAgAeAc@YeAy@}B{AiCSuD`@eCb@e@Jw@RcCnA_Cj@kAS{Ac@gCiAmBqBKYwAyAyBiA??{AK_@qBOyB??AQCQc@iCKQc@_@sAq@??}@]???A?AI?SEcDm@QA_D_B}@m@_@Ka@IGAICYMWKOEw@Q??y@Yk@}@?G@I??PeAh@uBOeCCUQ}BI{@V{Dh@qD^eC\\\\cAZqB\\\\{D`@_DBqBQaBAi@Aa@QkBm@kDW_BE[AMMyA??q@oD]}Cy@kBc@gA?yA@a@AUKi@EYAo@o@sCs@iDy@iCs@_B_@wAq@kDi@iEa@kCAK?i@CClAjEnAfFp@fBJ^@L?JDRNp@@D@PDb@Nl@`AU\\\\qANu@X_Ar@o@p@Qv@}@lBc@~C{@`@Wh@e@PIZQDEHGX_@pA_BrAqAjB}BzBoBHOLOpAiCf@aCz@gCt@kA^aA`B}ALAdBO\\\\MACh@Od@t@Cp@??GvDChAErBBlDGxBAp@R`CFlB?xA?|ACLF`AAT?D???J?BAH?F?@AJ@DA??RAH?p@?VAXD`@Ch@?R@f@Ej@Ef@EjA?PARCP@T?PA^?VBVEZADAF?R?TE^?@ALALARE|@?FADKlAQhBKn@OPORCNBTGd@BNG\\\\Ed@IRC^Kl@Qn@KXELCFERAHCNCJCLIROl@WvASf@Yv@I^ER{@lC[rAOp@Yv@YlAIVUbB[jBDlBS~@c@ZSFIBQDY?k@Ku@Am@RKJIZQn@OnA?NI^MjA[`Ae@v@Y\\\\SXYV_@\\\\o@~@u@fBk@dAq@lAiAvBi@jAg@~Bl@tB??^DbA^BBJF^LlAb@lAVf@NbA`@NJTKFAFEhAHz@TjAz@PJdAPbA^`AX??XFTl@GpAKtAIfBDb@FJ^X~@n@zB|A^h@l@z@TRtAlAnClAvD^fBm@VGbD_AXEnAS~Di@b@KnBc@bBW????n@MdBShASfBWz@Mh@`@Kb@o@zAaAbCeA`CaAtC{AvDoApBSb@QVk@nAu@lB[jAAJkAlC{A~DSr@AB[t@gA`CcBvDa@~@g@fA_BnDsArCcAlDCPK`@????]fBQfAUh@Od@e@fB_@`BMt@Qp@_@vAgA`E_AjEiAjE]tAKf@s@bDa@nBi@fBgAnBg@f@SRsArA[f@If@a@tA]bCUtDOdCEl@???Z??AL?J???K??AZG~@G\\\\EXOdAERO~@Sr@GLUf@ERO^_@`AFQGPWr@ELGJM^EJ??EL????EL??IV??[z@e@z@]t@??IRk@rAq@hEElEAREz@@Q[rBKXmA|C??qArDGTOf@c@vAe@rAGT??Y|@??q@nBGR{@bCOTkAdDy@tCITOf@w@hCM`@M^{@`CoAtDeAhEc@pE]jDIh@_@rDAt@e@vDUnDKd@@CIKCG@DM~Ak@tE_@xEYxEWnFWtE]xESbD@f@UfDg@vFWzCK|@UjE[~DWbEMjAaAjNMzE_@pEKzBEv@OnBKl@YfDAT??SzDGbB?TIrBS|@]jDOfGKp@OpC_@xEWtE_@rE]xE[vE]zEMnDMhB?FAA@~@]`CMx@SxCSxEYtDAr@GVEfASlBS|BYtEKdBUxD[|DWnDSnCSdE[tEUjCAf@SxAYrE_@zEMxDWpFE`@UxC[tEQ~ESjEEbB??ADEj@GXE`AM`A]bBMrBCr@KdBGpBMtAGpAG~D[dEUpDEdBS~DWtFKfDObBKxAGn@M~B`f@jkC??LLLH??`BpADDEEb@VGEl@d@HFNLFB??DFTRHJp@j@JDHH??^\\\\dAx@????pB`BHH??JHz@v@XRlA~@ZTx_@lXFJ\\\\Vh@f@??b@TBBJHLJZZf@j@xAtBt@fAPXjBrChAzB????LTLRVj@DHHZR^t@fAXv@`BpDvBlDdC~DlB|CrBjDbAbBb@j@pB`D|BbDpBlC|@zAp@`@NNlA|ATd@??l@fBz@vCXhAHVBDBTp@xBzAdEvAfEDNbAfDjA~CfAtCj@bBDPDFTh@Vv@j@vA`@hAx@pB^dAHPp@~A~ArDFL??`AdCl@vA^v@^z@vA|CFPjAhCJN^d@p@xAP^DLz@~Ax@rA??BJj@nAVn@??CI\\\\t@z@bBBD`@j@Zv@Vn@~@vBl@xARj@CI\\\\fAnA`E`B~DzApCV`@HP??HP|@bBp@x@P^??vAjC????HLp@bB??@B??@Dh@rAvAbCzA~Dj@rBPh@r@rB`AxA|AdCvBlDbA|ArAlBtBtCzAxB`BtB|AdBv@dALR`CbCrBjBdAhAVX`A~@v@~@JHHLj@r@JLJL??d@l@nApAb@d@bBnBx@r@FJV^`@VRZf@j@P^t@bAxBtBbC|ClA|ARVDFxAbCjAhBn@fAtBrDrB~CRRpAjB|BdDjBjB~BzC`CbDxBxC|B~ChCxCp@d@rAhAfCjCtChCzCdCjA`AhA|@|AtA`Az@`@ZpAf@??~BNnB@vACd@w@f@yAb@gA^]TSz@y@PQFKHIJGBEFO\\\\UV@B?r@Ht@BB?XD`@Fd@Fr@Hv@?b@?B???X?ZCL?~@@n@Fz@B@Ah@HZAXBJB\\\\Bx@Rp@H^f@Gd@??Id@O~@MbA??Mx@g@hCo@`CaA|AiApC{@rBgAhCQz@????k@fAIT[n@]n@kAYuAeAUOEGk@k@QQUUOMCE_@e@aAkA_@a@a@m@QMw@{@uA}AoAkAs@u@qB_CmAqAo@c@{@o@gAaAk@i@OQw@i@_@k@}ByB_DeCwCiCqCcCgD{CiCyCi@o@KOoAyAiAwAeB_CaCwCi@u@KM??KK??c@g@i@q@QW????_CwCuBmC??IMsBkDo@iA{@kBwBqD{@oAAC?@??A@EE??CKOg@q@u@AAw@{@_CyCu@}@IGMWQUMWo@u@MO}@aAoAuAwB_CkCyCmBqBOMEEiBcBcCkCoCyBsBwB][gCyC_CmC}B}CmAoB??LPMQs@gAyBsDmBmDGGCG??GGw@_BcAiB??UkA[yAi@}AgAsB_AoB{@eBOWIQaAuBu@qAKOUe@y@_BCCw@_Bg@aA{@gBHPIQgA{By@eC}@iCa@y@GQ??u@kBy@qBcAaCEI]s@kA_CcAwB??[k@sAsCyAyC_AgBe@_AQ_@w@mA_@eAk@uACE_@eAmAeCYy@??k@_BQg@_ByDm@aBq@uAs@iBc@oAs@_BCGq@mBw@eC[cASk@Qs@m@}AWu@GUk@mBGOu@sB??Wu@HPIQWu@GO??EM[{@Ss@i@qBFRwA{Ea@mA??]w@e@m@c@i@SWaBoBc@o@cAuAwBiCaAyAmAsBe@q@sBoDsBcDc@i@_@k@GGqBmDcBmC{AwCaAuBAAa@y@Qi@EO??_AgBUe@sBmD}@kAOW{@oAkA}Ae@g@q@w@iB}AEEECOI_Ae@??g@a@aAk@OK??m@]OK??o@_@UMUM??KG??KIKG??IEGEc@_@iAy@GAs@q@KI????[U??OM??MK??_BkAOMMK????m@g@YY[YUOEEs@e@KI??????cBsAUSUQSM??Y[g@c@u@o@mAgAuA_AmA_As@m@s@i@??g@c@??MKOKYUWQ????IGIK}AoA??qAeAOQ_@]YS??IGgA_A??OOiAgAgAcAs@{@u@q@s@y@m@q@q@KA?IIAACGKUKOEEEIYYIKKMIOCEKEIIEEOOGGA?EIGGACEEOIGEUMCCMMEGIK]W[SSUSY]a@MIa@g@]SKGk@g@C?[QUMUQeAm@IKw@a@YQa@Ga@?W~A?lCVjB@dD@HEv@Br@Bt@?BEKUe@Em@??????b@sGSFEu@M_EIeAS@?If@[X@L@LBDBZHHBD@n@Zh@Zb@d@ZNPJh@n@XXFHh@h@PNJJTLLD^^HLb@d@p@j@R\\\\HLx@t@t@Zb@DRVZd@DJTHl@XDLD^b@Zd@n@x@v@p@jABDp@r@bBlA??lAbA??XX??b@\\\\ZVFD\\\\\\\\TR\\\\VPL????HFXTl@b@^Z??p@d@HHZR??ZX~@n@XVTTZTNL??NJ??`Ap@lAfAZXLJ??LJl@b@d@`@p@n@|AbAbAz@FFjAdAlAfAxAhA`BzArAx@hAr@??GEvA~@d@VzBnA??fB|@????NH`Av@Z^V^??FDNJFD??j@ZPPJNPRrA|A\\\\b@r@t@JNdAnArA`CdApBVl@\\\\l@@Hd@hAb@|@lAlCn@vAt@rAzBhD|BhD|BdDzAlCTb@????JPjBxCfCnD|BrCj@r@PPHLBD@BRVZd@z@lAV\\\\|AhEv@~CHVPd@DVz@dCrArDjAhDDNFP`ArCpA|DtA~DpAlDFPfAbCZz@t@jB??Rb@????Pb@JRtAdDtAvDx@vBTh@bAnBHP`AhBh@jAb@`AP\\\\BDf@`A\\\\x@FLDHrAjCT^BD??LXFP|@fBHRbAnB@DTd@r@xAdAbCXt@FF??DFLTDR????Rn@d@lAL`@x@fC~@fCFRXn@xAjCr@jAHVTX??p@lAd@v@??p@vAj@p@EER`@b@hA??@D@@??@D????DBj@zA??DPz@rAn@~At@jBd@fBPZl@jBRf@??LRnAdBPZFHj@dA|ArCz@rAj@x@??`C`DbCzCbCbDhCtCjCrCrBpBZZj@j@vA|AHHIIHH??p@r@LHp@r@X\\\\LLMM??LLZ^zAfBd@d@ZZ??pAxAp@p@^b@`@b@X^RXp@t@`@l@^b@p@x@??rBhCfBpB`AxAtBjD^l@lAzBxBpDzB|CzBbDrBtCfCxCbC~C??dCxCdC~CfCbDfCjCxB|BvC`CbClBz@~@??xAnAtBjBrAbADBtA`ArALL?HC\\\\?h@BXJVCN?b@KP@n@H^WZ_Al@iBb@w@RUXWb@a@b@_@TWLGJGXKTEHBj@@h@Gd@DHE^N|@Pt@FTAB?DCdAE|@GnBRL@??nBLl@F@@^DpAJVRSlASdBQhA]pBCPSl@??GN]vAi@pAeAtB{@zB_A~Bc@nAKRK`@M`@M`@O^ELKNQXUn@Dp@Lf@PnA@H@d@H`CPxDJdAN~@PbATfBHn@T|A`@nCb@pCNx@JZLlA^|AHl@??Fd@PhAFPDR??F^VbBRfATrAV`BBT?H??BHJdAXnBDjBFx@DzBBp@Bz@@x@A`@DpAHhDDxA@N@P@v@L`D@L??JnCFfDJpDDfB@XB`@Bl@D\\\\FXE`@?|@?x@@tA@d@Fl@Fj@?N?????????b@??@h@??B`A??AO@NDvADV@`@Bx@?E?L@hADpA?ZFxBBv@?ZAv@FbA???J@nA?H??AHBj@??@H?VAN??BT??@LZzAFJ??Nh@b@rADn@?T??MbAETEPET??GT????Of@DS??K^??Sp@Od@GVw@|BIt@E`@?\\\\An@Hv@Ft@??HL^t@X~AVzC@NRrAZrDLt@Jt@Jz@f@dElA`Ef@jA\\\\^bBfD~BbE`BvDfAhE^tCB`AJvEN~AFb@h@xB~@`Ez@vD~@bEx@`Ez@bEv@`Ex@dEt@zD`A|Dz@xEZjEVvD@RVtDV`E\\\\fERxCB??r@Fd@Hx@VhDVjD@L??X|C\\\\tC?JRzB^fE`@dEZdE^zDb@rD\\\\lEVzD^`E`@vEXbEl@jEVdEArBNzB?P?P?Q??DxDJfEDnD@|@Sb@sAZuBNyBN??cCNuCT}BVyBTeCV_CR}AR??g@F{BTmBP_ALcANE?mALeBRuBXg@L?@I?WF]D??@N?@DL@L???L@l@EpAe@`@??[S@D@L@D?A????@ALW?Dv@UNT]@CACACPYA??EQ?G??@e@RE@C??\\\\E????TA??X@D@D?H?TH@B@HKt@mAEG@O@I?g@k@AeB@KA??GAU?I@URQd~@y`@E_DG}Dk@cE??i@mEa@mE]oEW}E]sE]uE]sEc@mEe@oEa@eEk@yEOyBQcD]yD????Gw@My@ImAG_A[cE]sE_@uE_@oE]oEw@iE{@wE_AkEw@mEw@iEg@{BYqAaA}E}@mEy@yCMg@{@kDe@_BIo@@w@AqBUoEy@oEmAeEmBgDoBkDaB{D{A_Eq@kEU}B[kDY{D]uD??m@wAQYGGEWKY??AM???_DHk@b@gBV_ALYh@_B`@}AH_@F]?cAg@yA??g@gA??EM??Uw@Cw@AuAC}A???K???M@_C?I??AYCm@MsC?U??CcAAU??Ci@?m@@k@??I{C????C]MeC?M??AY??EmBEkC??Ao@??AM??GqDK_EOyC??AQ??@}@K_CIiB??AUAk@Ai@??AW??AUAUCyCO{DEy@???i@I_B?UC}@CS?????UCmA@R????ASSkDKa@E[U{Ae@{BCUCIQy@CKAKQy@OaBUsA??????CM????AKQeBGYEKKi@e@aDI_@??c@}BYqBQs@Ok@SiAMcAG{@Ei@??KeCGs@IcB??K{BOaAQmAy@oAsAkAkAmAs@o@c@c@UQk@s@??QSwAeBSKK[{@kA??SUsBsBw@s@qAuAuBmB??eAgA]e@m@WsAmAgC{BsBkByAkAqBgB}AuA}BwBmCaCcCwCcC}CaCyCcC{CgBwB????IK??KM??o@w@o@}@????c@m@cB{BU[}@mAIMa@i@qBkDqAaBy@uBiBaDcAoBo@u@a@k@YGIKJEJLh@\\\\BB@A@?????Pd@n@`AXb@x@nArAbCzA`CfBdDzBbD`C|CpBfCzB~C~BvC~BbDbCxC~BnCzB~B??BB~@`AlCfCzCbCrC`CrBnBbBtAbBtA`@`@dBd@xAJfAL`B?z@a@Ja@FSVe@x@qBdAaALQbByAvAMhABFBXF^?ZJPDt@HHAD?z@K~@H|ABjBJV?|@D|@^~AGnBQvBGxCaA~@k@`DmAdCeA~Bu@bBm@VKr@UtA[bBc@LE\\\\MlCy@jBm@TIFA??`Bo@BAz@MpBk@|DoAxCcAzCy@??b@OtAc@XOt@[fB}@hBw@fDkArAe@??vAg@??vCuAfCkAtAs@NCdAg@jBw@nBe@n@MbCa@rDq@|Cs@bCw@dCu@pDuA\\\\A??`Cw@b@KpA[nD_@|DK??|DI|DKzD_@|De@nEY~DY~D_@vDg@~De@`Em@vDsAlDwAbDqA|D_BjDsAbDgAdDy@nBYJ?JAbBWhCc@`AMtASxAU~Co@jAUv@]tA}@x@m@`@M`Ao@pAw@hBy@tAcAvAw@vBoA|@o@r@]^[pCiB`DcBnDmAtC_AnCaApDmA~DyALELC??zAi@pDoAvDkArCeAfA]??b@M|C_AtDoA|AiA??HQdCcB????fDaBlASV@z@_Bt@oDFO????JcALk@DMBMBO??????^oCf@uEp@mEr@mEl@mEr@cEf@uC`@qDj@kEt@oEr@gFRgB??VgBr@mEn@_DJe@f@_Dv@iE\\\\{BDWFq@^_D????BUd@sEr@mEd@cE@UPwENcFhC_E@cGT{BHuA`AmD??jA{DzAaEpAoDh@kB?ERmB`@}D????@WP}@BQBONy@DSDSDSZaB????BSHk@BS|@yDN_@FS??DQd@}AFS??`@mAv@{BlAqDNg@r@oDTq@@EFYD_@By@QaBO}AQqBKy@e@eBi@wCg@aCa@{BIq@UiAKoBXgA?ANa@@ERa@h@sAtAmDtAqDjAuCRc@HQ|@}BxAeDHS~A{D`B{DzAwDnA_EhAiEdAeEZsA`@{B~@oEl@uELuEHuE?uCM{AW_@????}A}A??g@c@MKkAkAg@e@KKOMMK??{@q@sC_C??aC_DqAcEs@mESuEBuE\\\\sDhAaCv@w@??p@_@d@a@@EJK?AXWLSRKNU\\\\aAm@cAyCmBsAw@aAs@wAeAuC{AuCkByBiAy@s@oB_AsBcAkBu@uD_BuAe@m@YIEBAEGGIS}@ZgDd@sE`@kEK{A_@o@MWK[@]Ay@Cq@AsB@oDLqEf@mEn@gFb@sCL_Aj@oEZqE^iEpBgDvAsBTq@l@mEFyEq@iEe@iB_@_Aw@cBo@}AcAsB}@_CiAmC}AyCuBmBiCmAuA_@YGk@KaAi@y@YmA_@m@YiCm@eDv@oClA{AiBMcB?O?y@qAuEeBgDwAuEcB{D}AyD_CcDe@M??CB@FC?}@sAy@gBi@{@Q[MMCEa@y@k@y@??_@i@wBcD}BcD{BaD{BwCaC_DkBeBwCaBqDeAuDaAsCw@}Bk@{Be@mCi@{Ck@aCk@cBYmDY_EI}DIwDKsEO}CGwAKQIq@GcACk@GE@WG{CEeEM}DMmD{@uBgAo@k@aCaDSe@yAmC??????????kBqDkB}D_B}D_BsEQo@??kAqEkB_E}@cEQuEJuE^qEVo@VgA\\\\yCf@cEl@mEd@qELmEe@eEmA}DmAaEuAeEw@gFPuE|@_DFKxA{BVK\\\\]d@a@REPMz@o@nA{@z@i@z@c@j@_@RM????@A?A?A~@s@xBgApBmAfCcBxCqBxCgBrA{@|@i@??dBaA`BoA????LIlAy@vC}AxCaBtBaAnBeAnD}Ap@W??lBcAtAw@????????G?h@i@|BcB??hCcCNS`AqAfAsA@CJOzAwAnAsADC`B}BTc@PuA??????uBoAMO_@YwB}B}CoCeCuCoCsDaCyCcCcDsAcBGEEK{@sAoAaBc@w@_BuBwAqACCOIaAaA^uAf@uAl@sA`@_A??~@wB^mAl@{APSRg@x@{Az@qB|@iABENYf@yAf@gCLsBmAcA}C]mAOG?c@Gw@?EAMCw@GC?WBABE???AAGEKA}@Cy@Sc@EG?a@KwBQiBSuAC]AcCQo@@C?A?_AKgA[NkC????XuDHsDGqCAm@Mc@Bs@RmAEcCMcDASAc@OoCWsEQeECeAAAACEeACkDBeEDmELoAF_ABmACy@Ak@@QB{@EI?EAM?c@DUFa@Bw@CYDq@FkA@{@B_@KcAUi@m@s@Ym@g@aAk@aAm@}@qB}AgD_AiBg@gCQ_ESsCa@oASOA[QkDiAyDeA??iBZmDrAkAGsAsCXcE]sA???i@JsAFsB?K@oAHs@B[BM@GA?BQ@OLMj@Av@^h@LLBlAj@|CbA^LdBn@dAXJBj@N`AnA?L??AL??_@jBe@~AO`AAzBN~@PXn@Tv@^bBb@tDr@jADF?`BLxCJnBNnBVxB\\\\rBN|BSi@uCkCdBE`FdClCrArBBj@?TA\\\\?RAd@Dl@A~@CrB?hAE`AAhA?h@AXA^?`AA~@I`B?vCSlEBrCARBPB`CLtEVtEJhCHnAD|@Bz@?B@ZBVAzAHxA??@\\\\@rAFnBAvDKvDCn@?D??CLM|AU`D[pEObEQrBDXEp@OpCDnCdCnBnCpBnCvBzBzAzB~AxA`AlA~@hAv@~AvAnBnB^l@n@bABDNPd@x@tApBv@~@j@~@bB~BtB|CvBlCnBvBtC`CfCjB~ApAHDb@ZJRJDt@x@FPEL??ABUT]~@g@d@O^kAfAgBhBcCpCgBlBmBnCkAfA?@aAv@s@d@yA~@aDrA{DxAuDhA??aDdBgBdAAFIDgAt@}BzAcAl@mAz@oBpAq@b@q@`@m@Z_@Z[ZURIF?AOJCDOLiBjAoBlAk@d@e@\\\\}@n@_Aj@i@Ri@R??[Pg@Vm@Z_@Pe@Rw@p@k@`@o@d@y@h@g@j@e@d@??]t@CHMV??ITWd@Ij@Mz@[bAC`B@~@Jt@TfATn@NLJ`@Pv@Vv@B`@z@nCvApEx@`F??SfF??????i@dFo@nEo@tEOvAOrAOpBe@zEU|El@tEjA`EfAfEjAjE|A~DzAfDpAfD|BhDfC~CbDtCdDhBzDl@|DPzDPxDN~DFxDFxDPvDLzDH`EDxD`@bEt@fE|@pDt@jDz@fCl@tBj@zBh@LDhAb@xB|@lBnArBtBhB|BjArAj@r@nAvBxArBZNfAdBrBjCbAxAh@h@??b@d@Rf@Xf@LZhA|Bz@`BdAlBxAhCHXhAhBfAdDp@dCrAbEzAbCRXD?BAJEN?NBPF`@Rl@VXHd@@ZND@DDn@Rx@XJHVH`CbA~ClA??hDnAnDzAfCrAbBrA`B~B`BtD~ArDhApC@Bh@jAXf@??j@n@zAfC~AbD??`AxB??`@r@HHDBRJTLd@d@x@lCThC?T??Ah@@TFRLRdA~BfB`DrCxBpBdA|BvAdC|AdAh@r@`@h@^|B~AzCfBvChBlBfAxAz@xA~@dCtAtChBjC`BfBrAw@l@wAw@c@Oi@YcBcAcC{AcDiBoCeBiCaB}BsAmAq@??e@YaCsAgAq@c@U]QKISKa@UQKc@Wi@[iAs@mA{@o@e@cAq@}A_A_Be@wCiAwBHaD~AeDrBcBtDy@dE_@fE[tCg@rEYxE_@`Fa@dE[`Ca@vDK~AOjBWhCWlA?j@z@lAd@Nb@N~Ar@zAj@fA`@nAp@zAbApA`Al@XrBjAlC`BnCbBxBjA`CpAhAn@JF??b@T^VD@HD??BFp@b@Lr@y@nAc@r@yApA??WRy@rAgAzB]nEBjENxEHh@^pB@Hb@`Bv@bBpAbB~B~BzBnBlBlBdB~A????zAzA^pB??BZ??AjD??O|E]xEo@lEy@hDo@hDeAtD}@bEaAtD}@pCkAfCsAzD{AtD}AdDwAdDgAlCuAdDoAfDMXADABEFi@rAs@xBB`CHd@??@P??DRNr@ThA`@vBH^v@vDVbBTbALt@B`ADr@LhABnA?@Cn@E^m@tCWbB??YnAKTk@xA_@fAY`@??sAbEGR??uAzDw@zDGh@WzABWe@dDEV??CV]xDOxBC`@u@rBuAnDWx@c@fCgAzDoA`EYlA_@fBe@fDa@vChBz@x@`AoAv@aB_@QlDEhDAb@]tEYlB[hBaAtDg@`CWrAQvAi@pDo@hEi@rCCRMj@y@pEs@pEo@tEw@pEw@rEk@pEs@pEm@rEy@xEm@rEy@fFi@nEKv@??KnA??CNAJCh@AT??CRk@tCgApBoAr@eCpAcChA]NmAl@gDtAyC~@qA^eAb@}Bt@eDhAgDhAwBr@iC|@_DjAoDnAiA^[NcCx@yChA_CbAaClAuAp@i@ZiAj@_B`AmBlAsBnAkAj@uAv@_B|@s@b@[J_@T??iAr@oCbAeDp@eC`@??_APeB^cC`@}ARaDt@??uDhAwDrAcExAqDrAiDvAgDrAsDbAaEb@}Db@}Db@}DT}DT{D\\\\cEf@}DT}DH{DLqEXmDt@eB^_@JmA`@WL{Bv@{@Zq@NmDbAsDp@}Dv@oDv@{Bx@{An@uBz@qAh@gAh@sBfAgCdAeCx@}D~AcBv@q@^WLoCr@}C|@wBn@oBn@??s@RiBd@}Ab@G@eAVg@TeA`@yCr@{DnAoAV]LwA`@_Bh@cBd@_Bf@aBx@aAf@aBz@gBn@cBN{AJkALORM`AU`B]dC?M?LAFi@fCq@dC}@zBkAhCK`@EJm@vAyAvDs@tAMVc@|@a@@mB{AoBaBo@q@y@kAwA}Aw@u@{@eA??uAcBiAeAoBuBmCgCcA_AU[{Au@qBuBcCsB_B}AKGsBqBmCyBmCmCkCmC_AeAq@}@??KMW_@HPIQ??mBgC{ByC_CuC{@iA????UWc@e@KI??[e@KMKMs@{@iA_B??MOc@m@oBmCiB}CwAoCwAaCuAwBa@y@AAMYi@g@[c@_@EEWFGRRr@n@VR@BFL^l@l@lAfA`Bl@jATb@l@rAz@vAbAdBtAlBb@j@JJz@jAtBnCtBfCzBrCzAlBhA|AvAnBhB|BlBzB|A`BpBjB`CzBnC|BhC~BdCrBnBfB\\\\Vj@n@x@p@~BFzBF|BIrA}BpAcC^e@\\\\SdAeAtAc@T@RCIBxALzB`@z@Gv@EV?VGnAJ~BRt@Hn@JtAJPZMxA_@fCWlBc@pCm@~AkAxC??{@dCEL_AdC{AvCg@tA]n@AjA^fB@l@JrCJhCJbBH`A\\\\zA`@dDn@vDh@pCb@lCJp@Lv@F^VbBH`A??\\\\jA`@~C??BN????BNd@lCNfAJbA???J??Ft@JdADZ@h@DfAFxCPtC@dCDbDBn@??FhAJ|@DrB??BrA@j@Af@D~B@f@??NzCFhCHr@@b@?LFr@??@~BLvC@TBf@BXAn@??@bA@L?l@DzA@N??BV?P@n@@T??B\\\\Al@?f@BdAJbB@x@@|A@l@Dz@?~@@d@?f@@X??N`Aj@hB`@hDk@lC??EL????w@hCUt@??EVKb@CHWfA?b@Af@B`@Fr@BNBLZh@?FPb@DJPxAXtDTvBZpCXr@T~A\\\\vCz@pD~AvDlBlDlBlDt@vA??h@vB`AlE`@vERlEHdA\\\\nBfAlE~@fEz@jEx@fEz@lE|@jEx@jEz@jE~@rEt@jEd@xE`@vEZrE`@tEX|DJv@Ff@BT@PPvCZdERvC^rEh@nFb@pEb@rE\\\\tE`@tEd@xEb@vE`@tE`@xEh@rEb@pEDvDBxADvC??D~D??DhE??BhDe@|@I@iCR}DXaE^}D\\\\_E`@}D`@yD\\\\yDb@YBmANK@??mDd@cDV_ATEZ?LDV@?D^e@N????????????GFARBjAfAVt@F???C??B?H[iAWC_@\\\\@LC????R?RJ@BKp@FGFIBA??";
//        List<Double[]> locations = LineUtils.decodePolyline(encodePath, null);
        System.out.println(locations.size());
        Coordinate[] coordinates = new Coordinate[locations.size()];
        for (int i = 0; i < locations.size(); i++) {
            coordinates[i] = new Coordinate(locations.get(i)[1], locations.get(i)[0]);
        }
        LineString lineString = geometryFactory.createLineString(coordinates);
//        System.out.println(lineString);
//        System.out.println(lineString.getEnvelope());
//        System.out.println(lineString.getBoundary());
        BufferOp bufferOp = new BufferOp(lineString);
        bufferOp.setEndCapStyle(BufferOp.CAP_BUTT);
        Geometry resultGeometry = bufferOp.getResultGeometry(0.0005);
        System.out.println(resultGeometry);
        System.out.println(resultGeometry.getBoundary());
        System.out.println(resultGeometry.getCentroid());
        int numPoints = lineString.getNumPoints();
        double distance = 0.0;
        for (int i = 0; i < numPoints - 1; i++) {
            distance += CoreUtil.calculateDistance(coordinates[i + 1].getY(), coordinates[i + 1].getX(), coordinates[i].getY(), coordinates[i].getX(), DistanceUnit.METER);
        }
        System.out.println(distance);
    }

    public static void test2() throws ParseException, FactoryException {
        Integer epsg = 32632;
        String wkt = "POINT (5293201.002716452 1208988.4067087262)";
        //setup geometry point in utm coordinates (meter)

        // create geometry
        CoordinateReferenceSystem crs = CRS.decode(("EPSG:" + epsg.toString()));
        Hints hints = new Hints(Hints.CRS, crs);
        GeometryFactory geometryFactoryWKT = JTSFactoryFinder.getGeometryFactory(hints);
        WKTReader wktReader = new WKTReader(geometryFactoryWKT);
        Geometry geom = wktReader.read(wkt);
        geom.setSRID(epsg);


        // creates BufferParameters
        BufferParameters bufferParam = new BufferParameters();

        bufferParam.setEndCapStyle(BufferParameters.CAP_FLAT);
        // if using any other parameter result is as expected
        // bufferParam.setEndCapStyle(BufferParameters.CAP_ROUND);
        bufferParam.setJoinStyle(BufferParameters.JOIN_BEVEL);
        bufferParam.setMitreLimit(5);
        bufferParam.setSimplifyFactor(0.01);
        bufferParam.setQuadrantSegments(8);


        // creates buffer geom on point with 10m distance and use set bufferParameters
        Geometry bufferGeom = BufferOp.bufferOp(geom, 10, bufferParam);

        System.out.println(bufferGeom);
    }

    public static void makeShap(GeometricShapeFactory shapeFactory) {
        System.out.println(createCircle(shapeFactory, new Coordinate(77.342278, 28.604123), 0.001));

    }


    private static Geometry createCircle(GeometricShapeFactory shapeFactory, Coordinate coordinate, final double RADIUS) {
        shapeFactory.setNumPoints(32);
        shapeFactory.setCentre(coordinate);
        shapeFactory.setSize(RADIUS * 2);
        return shapeFactory.createCircle();
    }

    private static Geometry createBezierCurve(Coordinate start,
                                              Coordinate end,
                                              Coordinate ctrlPoint1,
                                              Coordinate ctrlPoint2,
                                              double smooth) {
        Shape curve = new CubicCurve2D.Double(
                start.x, start.y,
                ctrlPoint1.x, ctrlPoint1.y,
                ctrlPoint2.x, ctrlPoint2.y,
                end.x, end.y);

        // the value of the smooth arg determines how closely the line
        // segments between points approximate the smooth curve
        // (see javadocs for Shape.getPathIterator method)

        PathIterator iter = curve.getPathIterator(null, smooth);

        // a length 6 array is required for the iterator
        double[] iterBuf = new double[6];

        List<Coordinate> coords = new ArrayList<Coordinate>();
        while (!iter.isDone()) {
            iter.currentSegment(iterBuf);
            coords.add(new Coordinate(iterBuf[0], iterBuf[1]));
            iter.next();
        }

        GeometryFactory gf = new GeometryFactory();
        return gf.createLineString(coords.toArray(new Coordinate[coords.size()]));
    }

    //long,lat
    public static void calculateArea(List<Double[]> locations, double distanceBufferInMetre) {
        if (locations.size() < 2) {
            return;
        }
        Coordinate[] coordinates = new Coordinate[locations.size()];
        for (int i = 0; i < locations.size(); i++) {
            coordinates[i] = new Coordinate(locations.get(i)[0], locations.get(i)[1]);
        }
        GeometryFactory geometryFactory = JTSFactoryFinder.getGeometryFactory();
        LineString lineString = geometryFactory.createLineString(coordinates);
        System.out.println(lineString);
//        Polygon polygon = geometryFactory.createPolygon(coordinates);
//        double pow = Math.pow(distanceBufferInMetre * 10000, 2);
//        distanceBufferInMetre = 11000 * distanceBufferInMetre;
        Geometry geometry = doBuffer(lineString, distanceBufferInMetre);
        System.out.println(geometry);
        System.out.println(geometry.getArea()*11000);
    }

    public static Geometry doBuffer(Geometry geometry, double widthInMetre) {
        BufferOp bufferOp = new BufferOp(geometry);
        bufferOp.setEndCapStyle(BufferOp.CAP_FLAT);
        return bufferOp.getResultGeometry(widthInMetre);
    }
}
