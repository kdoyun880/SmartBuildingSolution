package com.example.cslab.hyundaifloor138;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanSettings;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

import static java.lang.Math.asin;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

import android.Manifest;
import android.os.Bundle;
import android.os.Message;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.bluetooth.le.ScanSettings;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;


import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


import static java.lang.Math.asin;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


//Bluetooth
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Environment;
import android.os.Handler;
import android.bluetooth.BluetoothAdapter;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    public static int cnt = 0;
    public String averxx, averyy = null;
    public int averageX, averageY, ANG, ID = 0;
    public double averx, avery = 0;

    private EditText Inputeditx, Inputedity, InputeditID;
    private TextView tView, tView1, tView2, tView3;
    private Button resetBtn, btn, inputbtn, button;


    private float x, y, z;
    private float transformedAccX, tranformedAccY, transformedAccZ, accpzd, accpzdd, accpzddd, laccpzddd, accp,
            pitch = 0, yaw = 0, roll = 0, qpitch = 0, qyaw = 0, qroll = 0;
    private double timeStamp = 0;
    private int c, k, l, ll, ckl, cd, cdd, cddd, cyd, cydd, cyddd, cyyd, cyydd, cyyddd, cyyyd, cyyydd, cyyyddd, tc, m, lc = 0, count, cc, cn, d = 0, input = 0, ptotal_count, pcount, rtotal_count, rcount, fourC = 0;
    private int i = 1, j = 0;
    private int YY, PP, RR = 0;
    private float minaz, maxiaz, lminaz, lmaxiaz;
    private String uptime, uptim;
    private float q0, q1, q2, q3;
    private int countState = 0;
    private String xxx, yyy;
    String Now, Now1, now2, Now3, X, Y, Z, AX, AY, AZ, RQY, GX, GY, GZ, GT, UP, MMM, EEE, dD = null;
    String es, WSE, WSE1, ms, ts = null;
    String QQY, QQP, QQR = null;
    private String sXXX, sYYY, sID;
    public int total_count;

    long[] SEC = new long[2000];
    long now, now1;
    private double mid, start, end, lend, de, dd, det, dete, detec, detect, tdetect, ldetect, ltdetect = 0;
    private double ss, mm, ee, lee;
    private double maxp1, minp1, lmaxp1, lminp1;
    long SEC1 = 0;
    private SensorManager sensorManager;
    float[] mMatrix = new float[3];
    float[] agMatrix = new float[3];
    float[] qMatrix = new float[5];

    float anglex;
    //pitch
    private float currentAnglePitch = -180, anp1 = 180, lminp = -95, minp = -95, maxp = -95, lmaxp = -95;
    private double psB, pitchStart, pitchMiddle, pitchEnd, lastPitchEnd;
    private int previousPitchDetect, pc, pk, pl, pll, pcn, pckl, pdm, pd, numBp, numLp, numL = 0;
    private int ptc, plc;
    private double minpB;


    //pitch 옆에서
    private float anp42 = -180, anp142 = 180, lminp42 = 180, minp42 = 180, maxp42 = -180, lmaxp42 = -180;
    private double psB42, ps42, pm42, pe42, lpe42;
    private int pB42, pc42, pk42, pl42, pll42, pcn42, pckl42, pdm42, pd42, numBp42, numLp42 = 0;
    private int ptc42, plc42;
    private float transformedQuaternionPitch;
    private double minpB42;
    private int ptotal_count42, pcount42;
    private float anp3 = -180, anp13 = 180, lminp3 = -95, minp3 = -95, maxp3 = -95, lmaxp3 = -95;
    private double psB3, ps3, pm3, pe3, lpe3;
    private int pB3, pc3, pk3, pl3, pll3, pcn3, pckl3, pdm3, pd3, numBp3, numLp3, numL3 = 0;
    private int ptc3, plc3;
    private double minpB3;

    //roll
    private float anr = -90, anr1 = 90, maxr, minr, lmaxr, lminr;
    private double rsB, rs, rm, re, lre;
    private int rB, rc, rk, rl, rll, rcn, rckl, rdm, rd, numBr, numLr = 0;
    private double minrB;
    private int rtc, rlc;


    float angle, angle1, angle2, quaternionYaw, quaternionPitch, quaternionRoll;
    float anglet, anglet1, anglet2;


    private static final String Tag = "LogCatTest";

    WebView wvLayout0401v3;

    private static final String[] PERMISSIONS = new String[]{Manifest.permission.RECORD_AUDIO, Manifest.permission.MODIFY_AUDIO_SETTINGS, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_NETWORK_STATE};


    //서버
    private Socket socket;
    BufferedReader socket_in;
    PrintWriter socket_out;
    String data = null;
    TextView output;





    //private ScanSettings settings;
    // File 처음부터 끝까지 읽기 위해서 길게 Setting
    int nBeacon = 1000;
    int RefIndex = 6000;
    int Ref_num;
    private int RefCount = 0;
    int syncCount1, syncCount2, syncCount3, syncCount4,syncCount5,syncCount6,syncCount7,syncCount8,syncCount9,syncCount10;
    int thresholdRssi = 0;
    int thresholdStep = 3;


    int SynchN, SynchY=0;
    double[][] ReferenceBeacon = new double[RefIndex][nBeacon];
    double[] RealBeacon;
    int [] floorChecker;
    private static final int REQUEST_ENABLE_BT = 1;

    FileReader fis_Ref_Line;

    String uuid;
    String major;
    String minor;
    String TxPower;
    String[] StringT1;
    String[] Store_Test_Point=new String[nBeacon];
    // Bluetooth
    String Path = Environment.getExternalStorageDirectory().getPath();
    String RefPoint = "20170814.txt";
    String UUIDFilter="20170814";
    String File_Result = "Result.txt";

    File ReferencePoint;
    String[] RefString = new String[104000];
    String[][] RealString = new String[nBeacon][nBeacon]; // 여기서 100은 Beacon 갯수를 넉넉히 잡기 위해 100으로 하였음. 실제로는 57로 해도 무방


    //int IntTxPower;
    int KNN = 4;
    int Ref_numIndex = 6000;
    private int[] Ref_num_Store = new int[Ref_numIndex];
    private int Ref_num_R = 0;
    String MinimumRssi = "104";
    /*int[][] Result=new int [7000][nBeacon];
    int[] Ref_num_Store = new int[Ref_numIndex];
    int[] Ref_num_Result=new int[Ref_numIndex];*/
    //int[] Sorted_Ref_num_Result=new int[Ref_numIndex];

    private BluetoothAdapter mBluetoothAdapter;
    double[] FinalEstimated = new double[2];
    int Fing1=0;
    double PDRXXX, PDRYYY;
    private double FINXXX, FINYYY;
    private int VALUE = 0;
    private double XXX, YYY;
    private double PDRXXXT, PDRYYYT;
    private double estimated, smoothX, smoothY;


    //int i=0;

    public Handler mHandler = new Handler();
    private Handler mHandler2 = new Handler();

    private ScanSettings settings;

    //자기장
    int magX, magY, magZ;

    //인공지능
    //인공지능
    private static final String TAG = "MainActivity";

    private String return_msg;
    private String return_msg2;
    public static String floor;
    public static String[] floorString;
    public static int floorValue;
    public static String location;
    public static String[] locationString;
    public static int locationValue;
    public static String currentfloor;
    public static String[] currentfloorString;
    public static int currentfloorValue;
    public static String packetmode1;
    public static String packetmode2;
    public static byte[] packetmode1_byte;
    public static byte[] packetmode2_byte;
    public static String token;

    public static String UID;
    public static String positionX;
    public static String positionY;
    public static String positionZ;

    public static int XXXI, YYYI, CF;
    TextView textView;
    TextView textView2;

    //###floors
    int floorLevel;
    //20170818
    int BfloorLevel=12;
    //
    int MC=0;
    int Map=0;
    int FD=0;
    int fingerPrintingVlue=0;
    int fingerPrintDelayValue;
    //Angle Offset

    float AngleOffset=155;

    /**
     * 20170814
     */
    int maxBeacon;
    int maxBeaconIndex;
    int BmaxBeaconIndex;


    /**
     * 어느 비콘이 가장 많이 잡혔는지 확인하기 위한 변수
     */
     //20170818//20170823
    int floorCheckerOffset12=3;
    int floorCheckerOffset20=20;
    String address;
    int total_count_flag=0;
    int TMC=0;
   ///20170823
    int assureValue100,assureValue101,assureValue9,assureValue10,assureValue11,assureValue12=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.content_main);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

     /*   //Bluetooth start
        BluetoothModule();*/


        resetBtn = (Button) findViewById(R.id.resetBtn);
        //btn = (Button) findViewById(R.id.write);
        button = (Button) findViewById(R.id.start);

      /*  //인공지능
        NumberPicker picker1 = (NumberPicker) findViewById(R.id.picker1);
        picker1.setMaxValue(32);
        picker1.setMinValue(1);
        picker1.setOnLongPressUpdateInterval(100);
        picker1.setWrapSelectorWheel(false);
*/
        //FirebaseMessaging.getInstance().subscribeToTopic("news");
        // token = FirebaseInstanceId.getInstance().getToken();

/*
        // InputeditID=(EditText)findViewById(R.id.IDedittext);
        Inputeditx = (EditText) findViewById(R.id.Xedittext);
        Inputedity = (EditText) findViewById(R.id.Yedittext);
*/


        //tView = (TextView) findViewById(R.id.cntView);
        tView1 = (TextView) findViewById(R.id.cntView1);
        wvLayout0401v3 = (WebView) findViewById(R.id.Layout0401v3);
        //웹뷰 초기설정 변수
        WebSettings webSettings = wvLayout0401v3.getSettings();
        //웹뷰 초기설정
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setJavaScriptEnabled(true);


        webSettings.setLoadWithOverviewMode(true);
        // webSettings.setUseWideViewPort(true);


        //웹뷰 초기정보 보이기
       /* wvLayout0401v3.loadUrl("http://hojuworld.dlinkddns.com:88/HYUNDAI/CORE_DATA/default.html");*/
        //초기정보 선택 버튼 리스너
     /*   wvLayout0401v3.goBack();
        wvLayout0401v3.loadUrl("http://hojuworld.dlinkddns.com:88/HYUNDAI/CORE_DATA/map_KUCE_F02.html");*/
        wvLayout0401v3.goBack();
        //  wvLayout0401v3.loadUrl("http://it.korea.ac.kr/HYUNDAI/CORE_DATA/map_KUCE_F01.html");
     /*   wvLayout0401v3.loadUrl("http://hojuworld.dlinkddns.com:88/HYUNDAI/CORE_DATA/map_HDRND_F01.html");*/
        // wvLayout0401v3.loadUrl("http://hojuworld.dlinkddns.com:88/HYUNDAI/CORE_DATA/map_KUHS_Fb01.html");
        //Bluetooth start
        refresh();
        BluetoothModule();
        // refBeacon();//Fing1==1안에
        refreshFloor();
        mBluetoothAdapter.startLeScan(mLeScanCallback);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               floorChecker();
                if(FD==1){
                    FloorDecision();
                }
                if(floorLevel!=BfloorLevel){
                    //floor decision
                    refBeacon();
                    MapCalling();

                }
                Log.d("MAP"," "+Map);
                double FinalEstimatedPositionX = 0;
                double FinalEstimatedPositionY = 0;
                FinalEstimated[0] = FinalEstimatedPositionX;
                FinalEstimated[1] = FinalEstimatedPositionY;
                finalEstimated();
                XXX=FinalEstimated[0];
                YYY=FinalEstimated[1];
                Log.d("XXX1",""+XXX);
                Log.d("YYY1", "" + YYY);

                DelayPositionSend(XXX,YYY);
                BmaxBeaconIndex=maxBeaconIndex;
                refreshFloor();
                //Delete_Button.setEnabled(false);
            }
        });

    }

    private void DelayPositionSend(final double XXX, final double YYY){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("MapCalling5",""+XXX +" "+YYY);

                wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                Fing1 = 0;

            }
        }, 1000) ;
    }
    private void MapCalling() {
        Map = 0;
        //20170818
        //if(floorLevel==0) ##추가해서 바꿔주면 됩
     //   if (floorCounter == 10 || floorFirstChecker == 0){
       //     floorFirstChercker == 1;
        if (floorLevel / 10 == 0) {
            address = "http://it.korea.ac.kr/HYUNDAI/CORE_DATA/map_HDRND_F0" + String.valueOf(floorLevel) + ".html";
        } else {
            address = "http://it.korea.ac.kr/HYUNDAI/CORE_DATA/map_HDRND_F" + String.valueOf(floorLevel) + ".html";
        }
        Log.d("MapCalling1",""+floorLevel);
        wvLayout0401v3.loadUrl(address);
    //}
    }
    private void refBeacon() {
        //만약에 안되면 time에 관한 Buffer 만들기
        if(BfloorLevel!=floorLevel) {
            BfloorLevel=floorLevel;
            Ref_num=0;
            Ref_num_Store=new int[Ref_numIndex];
            RefCount=0;
            RefString= new String[104000];
            StringT1= new String[nBeacon];
            ReferenceBeacon= new double[RefIndex][nBeacon];
            Fing1 = 1;

            ReferencePoint = new File(Path, RefPoint);
            Ref_num_Store = new int[Ref_numIndex];
            RefCount = 0;
            /**
             * Radion Map을 읽어와서 배열에 임시저장하는 부분
             */

            try {
                fis_Ref_Line = new FileReader(ReferencePoint);
                BufferedReader bufferedReaderReference = new BufferedReader(fis_Ref_Line);

                while (true) {


                    String ReadReferenceFileLine = bufferedReaderReference.readLine();

                    if (ReadReferenceFileLine != null) {
                        if (ReadReferenceFileLine.length() < 10 && Integer.parseInt(ReadReferenceFileLine.substring(0, 1)) == floorLevel) {

                            //33 20 좌표를 3320 정수로 변환
                            Ref_num = Integer.parseInt(ReadReferenceFileLine.substring(2, 4)) * 100 + Integer.parseInt(ReadReferenceFileLine.substring(5, 7));
                            //Log.d("RefNumber",""+Ref_num);
                            Ref_num_Store[RefCount] = Integer.parseInt(ReadReferenceFileLine.substring(2, 4)) * 100 + Integer.parseInt(ReadReferenceFileLine.substring(5, 7));
                            //Ref_numCount=Ref_numCount+1;
                            RefCount = RefCount + 1;

                        } else {
                            // 비콘 값들을 index 3320에 집어 넣음 -> 비교를 위해서 String에서 Integer로 변경해서 집어넣기

                            RefString[Ref_num] = ReadReferenceFileLine;
                            // Log.d("File Read",""+ " " + Ref_num + " " + RefString[Ref_num]);

                            StringT1 = ReadReferenceFileLine.split(" ");

                            for (int i = 0; i < StringT1.length; i++) {
                                ReferenceBeacon[Ref_num][i] = Double.parseDouble(StringT1[i]);
                            }
                        }
                    } else {
                        Log.d("Check1", "" + 1);
                        break;
                    }
                    //Log.d("RefCount",""+RefCount);
                }
                fis_Ref_Line.close();


                /**
                 * 현재 위치에서 Beacon들을 스캔하고, RealBeacon에 중간값들을 할당해준다
                 * ex) 46번 비콘의 중간값 = RealBeacon[46]
                 */

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//Rebeacon

    private void refresh() {
        RealString = new String[nBeacon][nBeacon];
        Store_Test_Point = new String[nBeacon];
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        uuid = null;
        major = null;
        minor = null;
        TxPower = null;

        StringT1 = new String[nBeacon];

        // Store_Test_Point = new String[100];
        //   mBluetoothAdapter.startLeScan(mLeScanCallback);
    }
    private void floorChecker(){
        for(int i = 0; i < nBeacon; i++) {
            if(floorChecker[i] > maxBeacon) {
                maxBeacon = floorChecker[i];
                maxBeaconIndex = i;
                FD=1;
            }
        }

    }
    private void refreshFloor(){
        /**
         * 20170814
         */
        maxBeacon = 0;
        maxBeaconIndex = 0;
        floorChecker = new int[nBeacon];
        /**
         * 층 구분을 위한 변수 초기화 및 생성
         */
    }
     private void FloorDecision(){
         FD=0;
//20170818 //20170823//
         if(0 < maxBeaconIndex && 18 > maxBeaconIndex || maxBeaconIndex == 100 || maxBeaconIndex == 101 )
             floorLevel = 1;
         else if(maxBeaconIndex == 102 || maxBeaconIndex == 112 || maxBeaconIndex == 113 ||maxBeaconIndex == 301 || maxBeaconIndex == 302 || maxBeaconIndex == 303 || maxBeaconIndex == 304 || maxBeaconIndex ==305)//20170818 //20170823
             floorLevel = 2;
         else if(maxBeaconIndex == 103 || maxBeaconIndex == 114 || maxBeaconIndex == 115 || maxBeaconIndex == 116 || maxBeaconIndex == 117 || maxBeaconIndex == 118|| maxBeaconIndex == 210|| maxBeaconIndex == 211 )// 20170818
             floorLevel = 3;
         else if(maxBeaconIndex == 104||maxBeaconIndex == 212||maxBeaconIndex == 213)
             floorLevel = 4;
         else if(maxBeaconIndex == 105||maxBeaconIndex == 214||maxBeaconIndex == 215)
             floorLevel = 5;
         else if(maxBeaconIndex == 106||maxBeaconIndex == 216||maxBeaconIndex == 217)
             floorLevel = 6;
         else if(maxBeaconIndex == 107||maxBeaconIndex == 218||maxBeaconIndex == 219)
             floorLevel = 7;
         else if(17 < maxBeaconIndex && 27 > maxBeaconIndex || maxBeaconIndex == 108|| maxBeaconIndex == 220|| maxBeaconIndex == 221|| maxBeaconIndex == 250)//20170818
             floorLevel = 8;
         else if(maxBeaconIndex == 109||maxBeaconIndex == 222||maxBeaconIndex == 223)
             floorLevel = 9;
         else if(maxBeaconIndex == 110||maxBeaconIndex == 224||maxBeaconIndex == 225)
             floorLevel = 10;
         else if(maxBeaconIndex == 111)
             floorLevel = 11;
         else if(maxBeaconIndex == 200 || maxBeaconIndex==201)
             floorLevel = 0;
         //

         /**
          * 층 구분 코드 추가
          */
     }
    private double[] finalEstimated() {
        //Log.d("RealString111",""+IntTxPower+" "+RealString[56].length+" "+RealString[56][0]);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //mBluetoothAdapter.stopLeScan(mLeScanCallback);

        //final int X = Integer.parseInt(X_Coordinate.getText().toString());
        //final int Y = Integer.parseInt(Y_Coordinate.getText().toString());

        double[][] Result = new double[7000][nBeacon];
        //int[] Ref_num_Store = new int[Ref_numIndex];
        double[] Ref_num_Result = new double[Ref_numIndex];
        double[] KNNArray = new double[KNN];
        double[] KNNIndex = new double[KNN];
        int Ref_num_R = 0;
        double Median_Value = 0;
        double TotalWeightSum = 0;


        RealBeacon = new double[nBeacon];


        for (int i = 0; i < nBeacon; i++) {

            // Log.d("Check2i", "" + i+"n"+Count);
            int k = RealString[i].length;
            Log.d("Count",""+RealString[i].length);
            for (int j = 0; j < k; j++) {
                //  Count++;
                // Log.d("Count1234",""+k+"n"+Count+"n"+j);

                if (RealString[i][j] != null) {
                    Log.d("Check2+", "" + 2);
                    Arrays.sort(RealString[i]); // 크기별로 정렬시킨다
                    Median_Value = Math.abs(Double.parseDouble(RealString[i][j / 2])); // 정수형으로 모두 변경

                    // Beacon Number(i)에 중간 값을 할당
                    RealBeacon[i] = Median_Value;
                    //Log.d("Style",""+i+" "+j+" "+RealString[i][j]);
                    //Log.d("Style1234",""+Median_Value);
                }/*else{
                                RealBeacon[i]=threshold;
                            }*/

            }
        }

        for (int i = 0; i < RefCount; i++) {
            //Log.d("Check3",""+3);
            Ref_num_R = Ref_num_Store[i];// =>ok

            for (int j = 0; j < nBeacon; j++) {
                if ((RealBeacon[j] != 0) && ReferenceBeacon[Ref_num_R][j] != 0) {
                    //Result[Ref_num_R][j]은 실제위치와 라디오맵 좌표간의 거리 계산. 같은 vector distance가 나오지 않도록 랜덤 값을 더해준다.
                    Result[Ref_num_R][j] = Math.pow(ReferenceBeacon[Ref_num_R][j] - RealBeacon[j], 2) + (Math.random() / 10000);
                    //Log.d("Distance From RP", "" + j + " " +Ref_num_R +" "+ ReferenceBeacon[Ref_num_R][j]+" "+RealBeacon[j]+" "+Result[Ref_num_R][j]);

                }

                if (j == nBeacon - 1) {
                    for (int k = 0; k < nBeacon; k++) {
                        Ref_num_Result[Ref_num_R] = Ref_num_Result[Ref_num_R] + Result[Ref_num_R][k];
                    }

                    // 좌표와 현재 위치와의 거리를 출력해주기 위한 Log
                    if (Ref_num_Result[Ref_num_R] != 0) {
                        //   Log.d("Ref_num_Result",+Ref_num_R+"  "+Ref_num_Result[Ref_num_R]);
                    }
                }
            }
        }

        // 최소 값 네 개 찾기(KNN = 4를 위해서)
        double[] Sorted_Ref_num_Result = new double[Ref_numIndex];

        for (int i = 0; i < RefIndex; i++) {
            Sorted_Ref_num_Result[i] = Ref_num_Result[i];
        }

        Arrays.sort(Sorted_Ref_num_Result);

        int MinValueCount = 0;

        for (int i = 0; i < Ref_numIndex; i++) {
            if (Sorted_Ref_num_Result[i] != 0 && MinValueCount < 4) {
                //  Log.d("Check This Out",""+Sorted_Ref_num_Result[i]+" " +i);
                KNNArray[MinValueCount] = Sorted_Ref_num_Result[i];
                for (int j = 0; j < Ref_numIndex; j++) {
                    if (KNNArray[MinValueCount] == Ref_num_Result[j]) {
                        KNNIndex[MinValueCount] = j;
                        //  Log.d("1234",""+KNNIndex[MinValueCount]+" " +Ref_num_Result[j]);
                    }
                }
                //   Log.d("1235",""+KNNIndex[MinValueCount]);
                MinValueCount++;
            }
        }
        //   Log.d("Length",""+Sorted_Ref_num_Result.length);


        //Just For Check
        for (int i = 0; i < KNN; i++) {
            //   Log.d("Snoop",""+KNNIndex[i]+ " " + KNNArray[i] + " " + i);
            TotalWeightSum = TotalWeightSum + (double) 1 / KNNArray[i];
            //Log.d("TotalWeightSum",""+TotalWeightSum);
        }

        //  Log.d("TotalWeightSum",""+TotalWeightSum);


        /**
         *
         *
         *
         * FingerPrinting을 이용하여 최종적으로 도출된 좌표 뽑기
         *
         *
         *
         */

        double FinalEstimatedPositionX = 0;
        double FinalEstimatedPositionY = 0;

        // Double로 형변환하기
        for (int i = 0; i < KNN; i++) {
            FinalEstimatedPositionX = FinalEstimatedPositionX + ((KNNIndex[i]%10000) / 100) * (double) 1 / KNNArray[i] / TotalWeightSum;
            FinalEstimatedPositionY = FinalEstimatedPositionY + ((KNNIndex[i]%10000) % 100) * (double) 1 / KNNArray[i] / TotalWeightSum;
        }

        Log.d("Final Position", "" + "(" + FinalEstimatedPositionX + " , " + FinalEstimatedPositionY + ")");

        //  String FinalPosition = "(" + String.valueOf(FinalEstimatedPositionX) + " , " + String.valueOf(FinalEstimatedPositionY) + ")";

   /*     try {
            OutputStream ax = new FileOutputStream(Result_File,true);
            ax.write(FinalPosition.getBytes());
            ax.write("\r\n".getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
*/
        double X_pixel,Y_pixel;
        X_pixel = 180 + 25 * ((FinalEstimatedPositionX-10));
        Y_pixel = 930 - 25 * ((FinalEstimatedPositionY-10));


        /**
         * Beacon Sync하는 부분(Sync하는 비콘이 몇개인지 정해야 하고, 그 Beacon이 위치해 있는 Pixel 값을 알아야 함)
         * 98번 비콘이 스캔되면 특정위치로 포지션 변경
         * 99번 비콘이 스캔되면 특정위치로 포지션 변경
         * 100번 비콘이 스캔되면 특정위치로 포지션 변경
         */

        //Sync Point 공학관 1층 10,14
      /*  if(RealBeacon[19] != thresholdRssi) {
           // syncCount1++;
            if(syncCount1 > thresholdStep)
            {
                X_pixel = 1753;
                Y_pixel = 890;
                syncCount1 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount1 = 0;
        }*/
        //Sync Point 현대엘리베이터 1층 승강장(1)

/* if(RealBeacon[81] != thresholdRssi) {
            // syncCount1++;
            if(syncCount1 > thresholdStep)
            {
                floorLevel=1;
                X_pixel = 830;
                Y_pixel = 280;
                syncCount1 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount1 = 0;
        }
        //Sync Point 현대엘리베이터 2층 승강장(2)
        if(RealBeacon[82] != thresholdRssi) {
            // syncCount2++;
            if(syncCount2 > thresholdStep)
            {
                floorLevel=2;
                X_pixel = 830;
                Y_pixel = 280;
                syncCount2 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount2 = 0;
        }
        //Sync Point 현대엘리베이터 2층 접견실(3)
        if(RealBeacon[83] != thresholdRssi) {
            //   syncCount3++;
            if(syncCount3 > thresholdStep)
            {
                floorLevel = 2;
                X_pixel = 305;
                Y_pixel = 530;
                syncCount3 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount3 = 0;
        }
        //Sync Point 현대엘리베이터 2층 복도(4)
        if(RealBeacon[84] != thresholdRssi) {
            //syncCount1++;
            if(syncCount4 > thresholdStep)
            {
                floorLevel = 2;
                X_pixel = 705;
                Y_pixel = 605;
                syncCount4 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount4 = 0;
        }


        //Sync Point 현대엘리베이터 3층 승강장(5)
        if(RealBeacon[85] != thresholdRssi) {
            // syncCount5++;
            if(syncCount5 > thresholdStep)
            {
                floorLevel = 3;
                X_pixel = 830;
                Y_pixel = 280;
                syncCount5 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount5 = 0;
        }
        //Sync Point 현대엘리베이터 3층 공조실 앞 기둥(6)
        if(RealBeacon[86] != thresholdRssi) {
            // syncCount5++;
            if(syncCount6 > thresholdStep)
            {
                floorLevel = 3;
                X_pixel = 780;
                Y_pixel = 580;
                syncCount6 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount6 = 0;
        }
        //Sync Point 현대엘리베이터 3층 12시 방향 근무구역(7)
        if(RealBeacon[87] != thresholdRssi) {
            // syncCount5++;
            if(syncCount7 > thresholdStep)
            {
                floorLevel = 3;
                X_pixel = 180;
                Y_pixel = 630;
                syncCount7 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount7 = 0;
        }
        //Sync Point 현대엘리베이터 3층 5시 방향 근무구역(8)
        if(RealBeacon[88] != thresholdRssi) {
            // syncCount5++;
            if(syncCount8 > thresholdStep)
            {
                floorLevel = 3;
                X_pixel = 830;
                Y_pixel = 280;
                syncCount8 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount8 = 0;
        }
        //Sync Point 현대엘리베이터 3층 7시 방향 근무구역(9)
        if(RealBeacon[89] != thresholdRssi) {
            if(syncCount9 > thresholdStep)
            {
                floorLevel = 3;
                X_pixel = 180;
                Y_pixel = 930;
                syncCount9 = 0;
                SynchY=1;
            }
        }
        else {
            syncCount9 = 0;
        }

        //Sync Point 현대엘리베이터 8층 승강장
        if(RealBeacon[90] != thresholdRssi) {
            if(syncCount10 > thresholdStep)
            {
                floorLevel = 8;
                X_pixel = 830;
                Y_pixel = 280;
                syncCount10 = 0;
                SynchY=1;
                Log.d("floorLevel1",""+BfloorLevel+" "+floorLevel);

            }
        }
        else {
            syncCount10 = 0;
        }*/
        /**
         * Beacon Sync Point (Sync하는 비콘이 몇개인지 정해야 하고, 그 Beacon이 위치해 있는 Pixel 값을 알아야 함)
         * 수정할 부분
         * 1. RealBeacon[숫자] 숫자=> 비콘 넘버. 현엘 방문해서 설정 새로 하기
         * 2. syncCount 변수명 sync point마다 다르게 하기
         *
         * 현재 sync point 분포(총 10개)
         * 1층 : 입구 1, 승강기 1
         * 2층 : 접견실 1, 접견실 앞 복도 1, 승강기 1
         * 3층 : 12시 방향 근무구역 1, 5시 방향 근무구역 1, 7시 방향 근무구역 1, 공조실 앞 기둥 1
         * 8층 : 승강기 1
         */

        /**
         * 최종적으로 위치 보고
         * */

        /**
         * 20170814
         */
        // 승강장에 있다고 표시 (n층 승강장 Beacon # : 100+n)
        //20170818//20170823
        if((0<(maxBeaconIndex-100) && 12 > (maxBeaconIndex-100))|| ((maxBeaconIndex==301) || (maxBeaconIndex==302))||(9<(maxBeaconIndex-200) && 28 > (maxBeaconIndex-200))||((maxBeaconIndex==9) || (maxBeaconIndex==10))||((maxBeaconIndex==11) || (maxBeaconIndex==12)) ) {
            SynchY=1;
           /* assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=830;
            Y_pixel=280;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        // 2층 접견실
        else if(maxBeaconIndex == 112 || maxBeaconIndex==304|| maxBeaconIndex==305) {
            SynchY=1;
            /*assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=305;
            Y_pixel=530;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        // 2층 복도
        else if(maxBeaconIndex == 113|| maxBeaconIndex==303 ) {
            SynchY=1;
           /* assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=705;
            Y_pixel=605;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        // 3층 근무 구역 1(11시 방향)
        else if(maxBeaconIndex == 114) {
            SynchY=1;
            /*assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=180;
            Y_pixel=630;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        // 3층 근무 구역 2(1시 방향)
        else if(maxBeaconIndex == 115) { //20170818
            SynchY=1;
            /*assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=380;
            Y_pixel=630;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        // 3층 근무 구역 3(7시 방향)
        else if(maxBeaconIndex == 116) { // 20170818
            SynchY=1;
           /* assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=180;
            Y_pixel=930;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        // 3층 근무 구역 4(5시 방향)
        else if(maxBeaconIndex == 117) { // 20170818
            SynchY=1;
           /* assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=380;
            Y_pixel=930;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        // 3층 근무 구역 5(입구 쪽 복도)
        else if(maxBeaconIndex == 118) { // 20170818
            SynchY=1;
          /*  assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=680;
            Y_pixel=580;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        else if(maxBeaconIndex==200){
            SynchY=1;
           /* assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=830;
            Y_pixel=230;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;
        }else if(maxBeaconIndex==201){
            SynchY=1;
           /* assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=880;
            Y_pixel=280;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;}
        else if(maxBeaconIndex== 250) {   //20170818
            SynchY=1;
            /*assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=755;
            Y_pixel=355;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        else if(maxBeaconIndex== 18) {   //20170818
            SynchY=1;
           /* assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=355;
            Y_pixel=655;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        else if(maxBeaconIndex== 19) {   //20170818
            SynchY=1;
            /*assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=480;
            Y_pixel=655;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        else if(maxBeaconIndex== 20) {   //20170818
            SynchY=1;
            /*assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=605;
            Y_pixel=655;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        else if(maxBeaconIndex== 21) {   //20170818
            SynchY=1;
           /* assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            X_pixel=505;
            Y_pixel=505;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        else if((maxBeaconIndex == 100)) {
            //20170818
         /*   assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*/
            SynchY=1;
            X_pixel=255;
            Y_pixel=405;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;        }
        else{
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;
            Log.d("FinalEstimatedFinal",""+FinalEstimated[0]+""+FinalEstimated[1]);
        }
       //
        /**
         * Sync Point를 위한 코드
         */
        //작성중
/*  else if(((maxBeaconIndex==9)&&assureValue9>3)||(maxBeaconIndex==10)&&(assureValue10>3)||((maxBeaconIndex==11)&&assureValue11>3)
                ||(maxBeaconIndex==12)&&(assureValue12>3)||((maxBeaconIndex==101)&&assureValue101>3)) {
            SynchY=1;
          *//*  assureValue9=0;
            assureValue10=0;
            assureValue11=0;
            assureValue12=0;
            assureValue100=0;
            assureValue101=0;*//*
            X_pixel=305;
            Y_pixel=530;
            FinalEstimated[0] = X_pixel;
            FinalEstimated[1] = Y_pixel;     }*/
        // Count=0;
        return FinalEstimated;

    }

    private void BluetoothModule() {
        // 장치가 Bluetooth를 지원하는지 여부 Check
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "This Device does not service Bluetooth", Toast.LENGTH_LONG).show();
        }

        // Bluetooth가 켜져있지 않으면 Bluetooth를 킴(REQUEST_ENABLE_BT = 1로 선언)
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        settings = new ScanSettings.Builder().setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY).build();
    }


    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, final int rssi, final byte[] scanRecord) {


            runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    //mBluetoothAdapter.stopLeScan(mLeScanCallback);

                    // Byte로 나오는 Beacon 정보를 16진수로 바꿈
                    String TxTestString = bytesToHex(scanRecord);

                    // Nordic App 에 잡히는 uuid
                    uuid = TxTestString.substring(18, 50);


                    // major = 256(010A)
                    major = TxTestString.substring(50, 54);
                    int IntMajor = Integer.parseInt(major, 16);


                    // minor = 778(030A)
                    minor = TxTestString.substring(54, 58);
                    int IntMinor = Integer.parseInt(minor, 16);


                    // TxPower가 우리 실험시 Beacon Number
                    TxPower = TxTestString.substring(58, 60);
                    int IntTxPower = 256 - Integer.parseInt(TxPower, 16);
                    int Temp = rssi;
                    if(Temp == 0)
                        Temp = 104;
                    //     if((total_count%2)==1||(Fing1==1)){
                    // 우리가 실험에서 사용하는 Beacon만 Filtering//844412
                    /**
                     * 20170814
                     */
                    if (uuid.contains(UUIDFilter) && IntMajor < 1000) {

                        /**
                         * 0112233445566778899AABBCCDDEEFF0 -> UUIDFilter 변수로 변경, 우리 비콘은 1000번 넘는게 없으므로 Filtering 조건 추가
                         */
                        if (Store_Test_Point[IntMajor] == null) {
                            Store_Test_Point[IntMajor] = String.valueOf(Temp);
                            //Log.d("Rssi",""+Store_Test_Point[IntTxPower][0]);
                        } else {
                            Store_Test_Point[IntMajor] = Store_Test_Point[IntMajor] + " " + String.valueOf(Temp);
                            //  Log.d("Rssi",""+Store_Test_Point[IntTxPower]/*[0]*/);
                        }
                        RealString[IntMajor] = Store_Test_Point[IntMajor].split(" ");
                        Log.d("RealString",""+IntMajor+" "+RealString[IntMajor].length+" "+RealString[IntMajor][0]);
                        //Log.d("RealString",""+IntTxPower+Temp);
                        /**
                         * 20170814
                         */
                    //20170818//20170823
                        if(rssi>-90) {
                            if ((114 <= IntMajor && IntMajor <= 120) || (IntMajor == 305))
                                floorChecker[IntMajor] = floorChecker[IntMajor] + floorCheckerOffset12;
                            else if ((100 <= IntMajor && IntMajor <= 111) || (210 <= IntMajor && IntMajor <= 250) || (IntMajor == 301) || (IntMajor == 302) || (IntMajor == 18) || (IntMajor == 19) || (IntMajor == 20) || (IntMajor == 21) || (IntMajor == 9) || (IntMajor == 10) || (IntMajor == 11) || (IntMajor == 12))
                                floorChecker[IntMajor] = floorChecker[IntMajor] + floorCheckerOffset20;
                            else if ((IntMajor == 112) || (IntMajor == 113) || (IntMajor == 303) || (IntMajor == 304))
                                floorChecker[IntMajor] = floorChecker[IntMajor] + 2;
                        }
                        //수정중
                        /*if(IntMajor==9){
                            assureValue9++;
                        }else if(IntMajor==10){
                            assureValue10++;
                        }else if(IntMajor==11){
                            assureValue11++;
                        }else if(IntMajor==12){
                            assureValue12++;
                        }else if(IntMajor==100){
                            assureValue100++;
                        }else if(IntMajor==101){
                            assureValue101++;
                        }*/
                        //|| (IntMajor==9)|| (IntMajor==10) || (IntMajor == 11) || (IntMajor == 12)(1층 비콘)
                        /*if(IntMajor == 18 ||IntMajor == 19 ||IntMajor == 20 ||IntMajor == 21 || IntMajor==100
                           ||IntMajor == 301 || IntMajor == 302 || IntMajor == 303 || IntMajor==304
                           ||IntMajor==102 || IntMajor==103 || IntMajor==108 || IntMajor==112 || IntMajor==113 || IntMajor==114 || IntMajor==115 || IntMajor==116 || IntMajor==117 || IntMajor==118
                           ||IntMajor==210 || IntMajor==211 || IntMajor==212 || IntMajor==213 || IntMajor==214 || IntMajor==215 || IntMajor==216 || IntMajor==217 || IntMajor==218 || IntMajor==219 || IntMajor==220 || IntMajor==221 || IntMajor==222 || IntMajor==223 || IntMajor==224 || IntMajor==225 || IntMajor==226 || IntMajor==227 || IntMajor==250)
                            floorChecker[IntMajor] = floorChecker[IntMajor]+ floorCheckerOffset12;
                        else if()
                            floorChecker[IntMajor] = floorChecker[IntMajor]+ floorCheckerOffset20;*/
                        //
                        /**
                         * 각 비콘 별로 Count하기 위한 배열
                         */
                    }
                   /* if (uuid.contains("UUIDFilter")) {

                        Log.d("uuid", " " + uuid);
                        Log.d("Major", "" + IntMajor);
                        Log.d("Minor", "" + IntMinor);
                        Log.d("TxPower", "" + IntTxPower);


                        if (Store_Test_Point[IntTxPower] == null) {
                            Store_Test_Point[IntTxPower] = String.valueOf(Temp);

                            //Log.d("Rssi",""+Store_Test_Point[IntTxPower][0]);
                        } else {
                            Store_Test_Point[IntTxPower] = Store_Test_Point[IntTxPower] + " " + String.valueOf(Temp);
                            //Log.d("Store_Test",""+Store_Test_Point[IntTxPower]);

                        }
                        if(IntMinor == 1) {
                            floorLevel = 1;
                        }
                        else if(IntMinor == 2) {
                            floorLevel = 2;
                        }
                        else if(IntMinor == 3) {
                            floorLevel = 3;
                        }
                        else if(IntMinor == 8) {
                            floorLevel = 8;
                        }

                        if(IntTxPower==81){
                            syncCount1++;
                        }
                        if(IntMajor==82){
                            syncCount2++;
                        }
                        if(IntTxPower==83){
                            syncCount3++;
                        }
                        if(IntTxPower==84){
                            syncCount4++;
                        }
                        if(IntTxPower==85){
                            syncCount5++;
                        }
                        if(IntTxPower==86){
                            syncCount6++;
                        }
                        if(IntTxPower==87){
                            syncCount7++;
                        }
                        if(IntTxPower==88){
                            syncCount8++;
                        }
                        if(IntTxPower==89){
                            syncCount9++;
                        }
                        if(IntTxPower==90){
                            syncCount10++;

                        }

                        RealString[IntTxPower] = Store_Test_Point[IntTxPower].split(" ");
                        //Log.d("RealString",""+IntTxPower+" "+RealString[IntTxPower].length+" "+RealString[IntTxPower][0]);
                        //Log.d("RealString",""+IntTxPower+" "+RealString[IntTxPower][0]);

                    }*/
                    //  }
                }

            });

        }

    };

    // byte를 hex로 바꿔주기 위해 선언
    static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
//Bluetooth fin


    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION), SensorManager.SENSOR_DELAY_GAME);//중력빼고 가속도 delay_nor,ui.game,fastest
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_NORMAL);//방향센서
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_GAME);//중력+
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), SensorManager.SENSOR_DELAY_GAME);//자기장
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR), SensorManager.SENSOR_DELAY_NORMAL);//Rotation
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case Sensor.TYPE_ACCELEROMETER://중력
                agMatrix = event.values.clone();
                break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                mMatrix = event.values.clone();
                break;
            case Sensor.TYPE_ROTATION_VECTOR:
                qMatrix = event.values.clone();
                break;
        }

        if (qMatrix != null) {


            q0 = qMatrix[3];
            q1 = qMatrix[0];
            q2 = qMatrix[1];
            q3 = qMatrix[2];


        }

        if (mMatrix != null && agMatrix != null) {
            float[] orientation = new float[3];
            float[] R = new float[16];
            float[] I = new float[16];
            //가속도 센서, 자기 센서의 값을 바탕으로 회전 행렬을 계산한다.
            SensorManager.getRotationMatrix(R, I, agMatrix, mMatrix);//I는 기울기 R은 디바이스 시스템의 좌표계에서 세상 좌표계로, 그냥 방향 센서가 주는 데이터 직접 사용 시:완전한 결과 값이기 때문에 데이터의 좌표 기준을 변경 가공할 수 없다는 단점,그러나 회전 메트릭스를 가공하여 원하는 결과 도출 장점
            //디바이스의 방향에 따라 회전 행렬을 계산한다.
            SensorManager.getOrientation(R, orientation);
            yaw = orientation[0];
            pitch = orientation[1];
            roll = orientation[2]; // orientation contains: azimut, pitch and roll z,x,y


            //라디안에서 각도로 변환한다.
            angle = (float) Math.floor(Math.toDegrees(orientation[0]));//degree로 바꿈
            angle1 = (float) Math.floor(Math.toDegrees(orientation[1]));
            angle2 = (float) Math.floor(Math.toDegrees(orientation[2]));

            //각도의 범위를 0~360도로 조정한다.
            if (angle >= 0) {
                anglex = angle;
            } else if (angle < 0) {
                anglex = 360 + angle;
            }

            //각도 반전 한다
            if(anglex>=0){
                anglex=360-anglex;
            }
            //AngleOffset을 설정
            if(anglex>=AngleOffset){
                anglex=anglex-AngleOffset;
            }else if(anglex<AngleOffset ){
                anglex=360-(AngleOffset-anglex);
            }

        }


        if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {
            now = System.currentTimeMillis();
            uptime = Long.toString(now);
            uptim = uptime.substring(6);
            timeStamp = Double.valueOf(uptim);

            qyaw = (float) atan2(2.0 * (q3 * q0 + q1 * q2), 1 - 2.0 * (q0 * q0 + q1 * q1));//3 qyaw+180
            qpitch = (float) -atan2(2 * (q0 * q1 + q3 * q2), q3 * q3 + q0 * q0 - q1 * q1 - q2 * q2);
            ;//4
            qroll = (float) asin(2 * (q0 * q2 - q3 * q1));


            x = event.values[0];
            y = event.values[1];
            z = event.values[2];


            transformedAccX = (float) (
                    cos(-qyaw) * cos(-qroll) * x
                            + (cos(-qyaw) * sin(-qroll) * sin(qpitch)
                            - sin(-qyaw) * cos(qpitch)
                    ) * y
                            + (cos(-qyaw) * sin(-qroll) * cos(qpitch)
                            + sin(-qyaw) * sin(qpitch)
                    ) * z

            );


            tranformedAccY = (float) (sin(-qyaw) * cos(-qroll) * x //yaw roll pitch
                    + (sin(-qyaw) * sin(-qroll) * sin(qpitch)
                    + cos(-qyaw) * cos(qpitch)
            ) * y
                    + (sin(-qyaw) * sin(-qroll) * cos(qpitch)
                    - cos(-qyaw) * sin(qpitch)
            ) * z);


            transformedAccZ = (float) (-sin(qroll) * x
                    + (cos(qroll) * sin(-qpitch)
            ) * y
                    + (cos(qroll) * cos(-qpitch)
            ) * z);//radian
          /*  angle2=(float)Math.toDegrees(qyaw);*/
            quaternionYaw = (float) Math.toDegrees(qyaw) + 180;
            quaternionPitch = (float) Math.toDegrees(qpitch);
            quaternionRoll = (float) Math.toDegrees(qroll);


            if (quaternionPitch >= -100) {
                transformedQuaternionPitch = quaternionPitch;
            } else if (quaternionPitch < -100) {
                transformedQuaternionPitch = quaternionPitch + 360;
            }


            if ((countState == 0 || countState == 1)&&(floorLevel==1 ||floorLevel==8 )) {
                if (c == 0 && k == 0 && l == 0) {
                    if (transformedAccZ > 1.2) {
                        c = 1;

                        if (maxiaz < transformedAccZ) {
                            start = timeStamp;
                            maxiaz = transformedAccZ;
                            c = 0;
                            de = timeStamp;
                            accpzd = transformedAccZ;
                            accp = transformedAccZ;
                            if (maxiaz > 10) {
                                m++;
                            }
                        }
                    }
                }//최댓값, 문제 없음
                //20170818
                if((total_count%2)==1) {
                    Log.d("total_count_flag", "" + total_count_flag);
                    total_count_flag++;
                    if (total_count_flag >= 200) {

                        floorChecker();
                        Log.d("total_count_flag", "" + total_count_flag);
                        if (FD == 1) {
                            FloorDecision();
                            Log.d("MapCalling-1", "" + MC);

                        }
                        if (BfloorLevel != floorLevel) {
                            refBeacon();
                            MapCalling();


                            TMC = 1;
                            Log.d("MapCalling2", "" + MC);
                        }
                        if (TMC == 1) {
                            TMC = 0;
                            double FinalEstimatedPositionX = 0;
                            double FinalEstimatedPositionY = 0;
                            FinalEstimated[0] = FinalEstimatedPositionX;
                            FinalEstimated[1] = FinalEstimatedPositionY;
                            finalEstimated();
                            XXX = FinalEstimated[0];
                            YYY = FinalEstimated[1];
                            DelayPositionSend(XXX, YYY);
                        }
                        total_count_flag = 0;
                    }
                }
                //
                if (c == 1 && k == 0 && l == 0) {
                    lmaxiaz = 0;
                    end = 0;
                    detect = 0;
                    tdetect = 0;
                    if (transformedAccZ > 1.2) {
                        if (maxiaz < transformedAccZ) {
                            start = timeStamp;
                            maxiaz = transformedAccZ;
                            if (maxiaz > 10) {
                                m++;
                            }
                        }
                    }
                  /*  if (transformedAccZ > 0) {
                        if (cd == 0 && cdd == 0 && cddd == 0) {
                            if (accpzd < transformedAccZ) {
                                accpzd = transformedAccZ;
                                de = timeStamp;
                            } else if (accpzd > transformedAccZ) {
                                cd = 1;
                            }
                        }
                        if (cd == 1 && cdd == 0 && cddd == 0) {
                            if (accpzd > transformedAccZ) {
                                accpzd = transformedAccZ;
                            } else {
                                cdd = 1;
                            }
                        }
                        if (cd == 1 && cdd == 1 && cddd == 0) {
                            if (accpzd < transformedAccZ) {
                                accpzd = transformedAccZ;
                                det = timeStamp;
                            } else {
                                cddd = 1;
                            }
                        }
                    }
                    if (det - de > 200 && cd == 1 && cdd == 1 && cddd == 1) {
                        m++;
                    }//W*/

                    if (transformedAccZ < -0.5) {
                        k = 1;
                        if (minaz > transformedAccZ) {
                            k = 0;
                            minaz = transformedAccZ;
                            mid = timeStamp;
                            dete = timeStamp;
                            accpzdd = transformedAccZ;
                        }
                        if (minaz < -10) {
                            m++;
                        }
                    } //최솟값


                  /*  if (accp > 0 && transformedAccZ > 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp > 0 && transformedAccZ < 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp < 0 && transformedAccZ > 0) {
                        if (Math.abs(transformedAccZ - accp) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp < 0 && transformedAccZ < 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    }*/
                }//최솟값


                if (c == 1 && k == 1 && l == 0) {
                    if (transformedAccZ < -1.2) {
                        if (minaz > transformedAccZ) {
                            mid = timeStamp;
                            minaz = transformedAccZ;
                        }
                        if (minaz < -10) {
                            m++;
                        }
                    }
              /*      if (transformedAccZ < 0) {
                        if (cyd == 0 && cydd == 0 && cyddd == 0) {
                            if (accpzdd > transformedAccZ) {
                                accpzdd = transformedAccZ;
                                dete = timeStamp;
                            } else if (accpzdd < transformedAccZ) {
                                cyd = 1;
                            }
                        }
                        if (cyd == 1 && cydd == 0 && cyddd == 0) {
                            if (accpzdd < transformedAccZ) {
                                accpzdd = transformedAccZ;
                            } else {
                                cydd = 1;
                            }
                        }
                        if (cyd == 1 && cydd == 1 && cyddd == 0) {
                            if (accpzdd > transformedAccZ) {
                                accpzdd = transformedAccZ;
                                detec = timeStamp;
                            } else {
                                cyddd = 1;
                            }
                        }
                    }
                    if (detec - dete > 200 && cyd == 1 && cydd == 1 && cyddd == 1) {

                        m++;
                    }//W*/

                    if (transformedAccZ > 0.5) {
                        l = 1;
                        if (lmaxiaz < transformedAccZ) {
                            l = 0;
                            lmaxiaz = transformedAccZ;
                            end = timeStamp;
                            detect = timeStamp;
                            accpzddd = transformedAccZ;
                        }
                        if (lmaxiaz > 10) {
                            m++;
                        }

                    }//최댓값
                /*    if (accp > 0 && transformedAccZ > 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp > 0 && transformedAccZ < 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp < 0 && transformedAccZ > 0) {
                        if (Math.abs(transformedAccZ - accp) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp < 0 && transformedAccZ < 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    }*/
                }//최댓값


                if (c == 1 && k == 1 && l == 1) {
                    if (transformedAccZ > 1.2) {
                        if (lmaxiaz < transformedAccZ) {
                            end = timeStamp;
                            lmaxiaz = transformedAccZ;
                        }
                        if (lmaxiaz > 10) {
                            m++;
                        }
                    }

             /*       if (transformedAccZ > 0) {
                        if (cyyd == 0 && cyydd == 0 && cyyddd == 0) {
                            if (accpzddd < transformedAccZ) {
                                accpzddd = transformedAccZ;
                                detect = timeStamp;
                            } else if (accpzddd > transformedAccZ) {
                                cyyd = 1;
                            }
                        }
                        if (cyyd == 1 && cyydd == 0 && cyyddd == 0) {
                            if (accpzddd > transformedAccZ) {
                                accpzddd = transformedAccZ;
                            } else {
                                cyydd = 1;
                            }
                        }
                        if (cyyd == 1 && cyydd == 1 && cyyddd == 0) {
                            if (accpzddd < transformedAccZ) {
                                accpzddd = transformedAccZ;
                                tdetect = timeStamp;
                            } else {
                                cyyddd = 1;
                            }
                        }
                    }
                    if (tdetect - detect > 200 && cyyd == 1 && cyydd == 1 && cyyddd == 1) {
                        m++;
                    }//W*/

                    if (transformedAccZ < 0.5) {
                        cn = 1;

                    }
                  /*  if (accp > 0 && transformedAccZ > 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp > 0 && transformedAccZ < 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp < 0 && transformedAccZ > 0) {
                        if (Math.abs(transformedAccZ - accp) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    } else if (accp < 0 && transformedAccZ < 0) {
                        if (Math.abs(accp - transformedAccZ) < 3) {
                            accp = transformedAccZ;
                        } else {
                            m++;
                            accp = transformedAccZ;
                        }
                    }*/
                }//마지막
                if (c == 1 && k == 1 && l == 1 && cn == 1) {
                    if (maxiaz + lmaxiaz - minaz > 4) {
                        if ((end - start > 200) && (end - start < 800)) {
                            ckl=1;
                           /* if (Math.abs(maxiaz - lmaxiaz) >= 0 && Math.abs(maxiaz - lmaxiaz) < 5) {
                                ckl = 1;
                            } else {
                                m++;
                            }*/
                        } else {
                            m++;
                        }
                    } else if (maxiaz + lmaxiaz - minaz > 30) {

                        m++;
                    }

                    if (ckl == 1 && m == 0) {
                        if (total_count == 0) {

                            total_count = 2;
                            count = 2;

                            maxiaz = 0;
                            maxiaz = lmaxiaz;
                            start = 0;
                            start = end;
                            de = 0;
                            det = 0;
                            cd = 0;
                            cdd = 0;
                            cddd = 0;
                            accpzd = 0;

                            k = 0;
                            minaz = 0;
                            mid = 0;
                            dete = 0;
                            detec = 0;
                            cyd = 0;
                            cydd = 0;
                            cyddd = 0;
                            accpzdd = 0;

                            l = 0;
                            cn = 0;
                            cyyd = 0;
                            cyydd = 0;
                            cyyddd = 0;
                            accpzddd = 0;
                            tc = 1;
                            cc = 2;
                            ckl = 0;
                            m = 0;

                            countState = 1;

                         /*   if (tdetect == 0) {
                                de = detect;
                            } else {
                                de = tdetect;
                            }//w*/
                        } else if (total_count > 1) {
                            total_count++;
                            count++;

                            maxiaz = 0;
                            maxiaz = lmaxiaz;
                            start = 0;
                            start = end;
                            de = 0;
                            det = 0;
                            cd = 0;
                            cdd = 0;
                            cddd = 0;
                            accpzd = 0;

                            k = 0;
                            minaz = 0;
                            mid = 0;
                            dete = 0;
                            detec = 0;
                            cyd = 0;
                            cydd = 0;
                            cyddd = 0;
                            accpzdd = 0;

                            l = 0;
                            cyyd = 0;
                            cyydd = 0;
                            cyyddd = 0;
                            accpzddd = 0;
                            cn = 0;
                            tc = 1;
                            cc = 1;
                            ckl = 0;
                            m = 0;

                            countState = 1;
                           /* if (tdetect == 0) {
                                de = detect;
                            } else {
                                de = tdetect;
                            }//w*/
                        }
                    } else {
                        c = 0;
                        maxiaz = 0;
                        start = 0;
                        de = 0;
                        det = 0;
                        cd = 0;
                        cdd = 0;
                        cddd = 0;
                        accpzd = 0;
                        k = 0;
                        minaz = 0;
                        mid = 0;
                        dete = 0;
                        detec = 0;
                        cyd = 0;
                        cydd = 0;
                        cyddd = 0;
                        accpzdd = 0;
                        l = 0;
                        lmaxiaz = 0;
                        end = 0;
                        detect = 0;
                        tdetect = 0;
                        cyyd = 0;
                        cyydd = 0;
                        cyyddd = 0;
                        accpzddd = 0;
                        cn = 0;
                        ckl = 0;
                        m = 0;

                        countState = 0;

                    }
                    if (tc == 1) {

                        tc = 0;
                        double rad = Math.toRadians(anglex);//anglex를 걸음으로 바꾼 곳

                        averx = 78 * sin(rad);


                        Log.d(Tag, " " + averx);
                        avery = 78 * cos(rad);

                        Log.d("y", " " + avery);

                        Log.d("ang", " " + anglex);
                        lc = 1;

                        if ((averx > 4 || avery > 4 || averx < -4 || avery < -4) && lc == 1) {
                            lc = 0;
                            averageX = averageX / 4;
                            PDRXXX = cc * averx / 4;
                            averageY = averageY / 4;
                            PDRYYY = cc * avery / 4;

                        //20170818
                            if((total_count%2)==1){
                                refresh();
                                refreshFloor();
                                mBluetoothAdapter.startLeScan(mLeScanCallback);
                                XXX=XXX+PDRXXX;
                                YYY=YYY+PDRYYY;
                                wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");

                            }else if((total_count%2)==0 && (total_count!=0)){
                                Log.d("MapCalling0",""+floorLevel);
                                //20170818
                                total_count_flag=0;
                                floorChecker();
                                if(FD==1){
                                    FloorDecision();
                                    Log.d("MapCalling-1",""+MC);

                                }
                                if(BfloorLevel!=floorLevel){
                                    refBeacon();
                                    MapCalling();


                                    MC=1;
                                    Log.d("MapCalling2",""+MC);
                                }
                                // mBluetoothAdapter.stopLeScan(mLeScanCallback);
                                double FinalEstimatedPositionX = 0;
                                double FinalEstimatedPositionY = 0;
                                FinalEstimated[0] = FinalEstimatedPositionX;
                                FinalEstimated[1] = FinalEstimatedPositionY;
                                finalEstimated();
                                //MapCalling 유뮤 판별
                               if(MC==0) {
                                   //SynchN Detecting 무
                                    if (SynchN >= 10) {
                                        SynchN = 0;
                                        Log.d("MC0",""+MC);
                                        //SynchY Detecting 유무
                                        if (SynchY == 1) {
                                            XXX = FinalEstimated[0];
                                            YYY = FinalEstimated[1];
                                            SynchY = 0;
                                            wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                            Log.d("MC0SynchY1",""+SynchY);
                                        } else {
                                            XXX = FinalEstimated[0];
                                            YYY = FinalEstimated[1];
                                            wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                           /* FINXXX = FinalEstimated[0];//250/4
                                            FINYYY = FinalEstimated[1];
                                            PDRXXXT = XXX + PDRXXX;
                                            PDRYYYT = YYY + PDRYYY;
                                            estimated = Math.sqrt(Math.pow((PDRXXXT - FINXXX), 2) + Math.pow((PDRYYYT - FINYYY), 2));
                                            Log.d("MC0SynchY0",""+SynchY);
                                            if (estimated >= 100 && estimated <= 250) {//ok
                                   *//* XXX=FINXXX;
                                    YYY=FINYYY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                   *//*
                                                XXX = FINXXX;
                                                YYY = FINYYY;
                                                wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                                Log.d("MC0SynchY0esti in",""+XXX+","+YYY);
                                                // tView.setText(String.valueOf(XXX + "  " + YYY));
                                                Log.d("total_count%esti>=100", " " + total_count);
                                                Log.d("total_count%esti>=100", " " + XXX + " " + YYY);
                                                Log.d("total_count%esti>=100", " " + smoothX + " " + smoothY);

                                            } else {
                                                XXX = XXX + PDRXXX;
                                                YYY = YYY + PDRYYY;
                                                Log.d("total_count%esti else", " " + total_count);
                                                Log.d("total_count%esti else", " " + XXX + " " + YYY);
                                                Log.d("total_count%esti else", " " + smoothX + " " + smoothY);
                                                wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                                Log.d("MC0SynchY0esti out", "" + XXX + "," + YYY);

                                                //  tView.setText(String.valueOf(XXX + "  " + YYY));
                                    *//*Log.d("total_count%esti else", " " + XXX + " " + YYY);
                                    Log.d("total_count%esti else", " " + smoothX + " " + smoothY);
*//*
                                            }*/
                                        }
                                        // refresh();
                                    } else {
                                        if (SynchY == 1) {
                                            XXX = FinalEstimated[0];
                                            YYY = FinalEstimated[1];
                                            SynchY = 0;
                                            wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                            SynchN=0;
                                            Log.d("MC1SynchY1", "" + XXX + "," + YYY);

                                        } else {
                                            SynchN++;
                                            XXX = XXX + PDRXXX;
                                            YYY = YYY + PDRYYY;
                                            wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                            Log.d("MC1SynchY0", "" + XXX + "," + YYY);

                                        }
                                    }
                                }else{
                                   Log.d("Localwrong1",""+XXX+" "+YYY);

                                    MC=0;
                                    XXX=FinalEstimated[0];
                                    YYY=FinalEstimated[1];
                                   Log.d("MapCalling3",""+XXX +" "+YYY);
                                    DelayPositionSend(XXX,YYY);
                                }

                            }
                                //



                    /*        double FinalEstimatedPositionX = 0;
                            double FinalEstimatedPositionY = 0;
                            FinalEstimated[0] = FinalEstimatedPositionX;
                            FinalEstimated[1] = FinalEstimatedPositionY;
                            FinalEstimatedXY = finalEstimated();
                            FINXXX = FinalEstimated[0];//250/4
                            FINYYY = FinalEstimated[1];*/

                            /*XXX=XXX+PDRXXX;
                            YYY=YYY+PDRYYY;
                            Log.d("Final11",""+XXX+" "+YYY);
                            wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                            *//*RealString = new String[100][1000];
                            Store_Test_Point  = new String [1000];
                            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                            mBluetoothAdapter.startLeScan(mLeScanCallback);*/
                            /*if((total_count%10)==9){//ok
                                Log.d("total_count%==9"," "+total_count);

                                refresh();
                                if(VALUE==0) {
                                    XXX = XXX + PDRXXX;
                                    YYY = YYY + PDRYYY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                    Log.d("total_count%10==9v1", " " + total_count);
                                    Log.d("total_count%10==9v1", " " + XXX + " " + YYY);
                                    Log.d("total_count%10==9v1", " " + smoothX + " " + smoothY);

                                }else if(VALUE==1){
                                    XXX= XXX + PDRXXX + smoothX;
                                    YYY= YYY + PDRYYY + smoothY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                    Log.d("total_count%==9v2", " " + total_count);
                                    Log.d("total_count%==9v2", " " + XXX + " " + YYY);
                                    Log.d("total_count%==9v2", " " + smoothX + " " + smoothY);

                                }
                            }else if((total_count%10)==0){
                                Log.d("total_count%==0"," "+total_count);
                                VALUE=0;
                                smoothX=0;
                                smoothY=0;
                                PDRXXXT = XXX + (int)PDRXXX;
                                PDRYYYT = YYY + (int)PDRYYY;

                                double FinalEstimatedPositionX = 0;
                                double FinalEstimatedPositionY = 0;
                                FinalEstimated[0] = FinalEstimatedPositionX;
                                FinalEstimated[1] = FinalEstimatedPositionY;
                                finalEstimated();
                                FINXXX = FinalEstimated[0];//250/4
                                FINYYY = FinalEstimated[1];

                                estimated=Math.sqrt(Math.pow((PDRXXXT-FINXXX),2)+Math.pow((PDRYYYT-FINYYY),2));
                                if(estimated>=100&&estimated<=250){//ok
                                   *//* XXX=FINXXX;
                                    YYY=FINYYY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                   *//*
                                    VALUE=1;
                                    smoothX=(FINXXX-PDRXXXT)/10;
                                    smoothY=(FINYYY-PDRYYYT)/10;
                                    XXX=PDRXXXT+smoothX;
                                    YYY=PDRYYYT+smoothY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                    // tView.setText(String.valueOf(XXX + "  " + YYY));
                                    Log.d("total_count%esti>=100", " " + total_count);
                                    Log.d("total_count%esti>=100", " " + XXX + " " + YYY);
                                    Log.d("total_count%esti>=100", " " + smoothX + " " + smoothY);

                                }else{
                                    VALUE=0;
                                    smoothX=0;
                                    smoothY=0;
                                    XXX=XXX+PDRXXX;
                                    YYY=YYY+PDRYYY;
                                    Log.d("total_count%esti else", " " +total_count);
                                    Log.d("total_count%esti else", " " + XXX + " " + YYY);
                                    Log.d("total_count%esti else", " " + smoothX + " " + smoothY);
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");*/
                            //  tView.setText(String.valueOf(XXX + "  " + YYY));
                                    /*Log.d("total_count%esti else", " " + XXX + " " + YYY);
                                    Log.d("total_count%esti else", " " + smoothX + " " + smoothY);
*/
                    /*            }


                            }else{//ok
                                if(VALUE==0) {
                                    XXX = XXX + PDRXXX;
                                    YYY = YYY + PDRYYY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                    Log.d("total_count%elsev0", " " + total_count);
                                    Log.d("total_count%elsev0", " " + XXX + " " + YYY);
                                    Log.d("total_count%estiv0sm", " " + smoothX + " " + smoothY);

                                }else if(VALUE==1){
                                    XXX=XXX+PDRXXX+smoothX;
                                    YYY=YYY+PDRYYY+smoothY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                    Log.d("total_count%elsev1", " " + total_count);
                                    Log.d("total_count%elsev1", " " + XXX + " " + YYY);
                                    Log.d("total_count%estiv1sm", " " + smoothX + " " + smoothY);
                                }
                              *//*  XXX=XXX+PDRXXX;
                                YYY=YYY+PDRYYY;
                                // tView.setText(String.valueOf(XXX+"  "+YYY));
                                wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                Log.d("total_count%", " " + XXX + " " + YYY);*//*
                            }
*/

                            /*//지문인식 결합
                              if((total_count%19)==0){
                                  XXX=XXX+(int)PDRXXX;
                                  YYY=YYY+(int)PDRYYY;
                                  wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                  mBluetoothAdapter.startLeScan(mLeScanCallback);
                                  Log.d("total_count%19", " " + XXX + " " + YYY);
                                  tView.setText(String.valueOf(XXX+"  "+YYY));
                              }else if((total_count%20)==0){
                                  PDRXXXT=XXX+(int)PDRXXX;
                                  PDRYYYT=YYY+(int)PDRYYY;

                                  double FinalEstimatedPositionX = 0;
                                  double FinalEstimatedPositionY = 0;
                                  FinalEstimated[0] = FinalEstimatedPositionX;
                                  FinalEstimated[1] = FinalEstimatedPositionY;
                                  FinalEstimatedXY = finalEstimated();
                                  FINXXX = FinalEstimated[0];//250/4
                                  FINYYY = FinalEstimated[1];

                                  estimated=Math.sqrt(Math.pow((PDRXXXT-FINXXX),2)+Math.pow((PDRYYYT-FINYYY),2));
                                  if(estimated>=100){
                                      XXX=FINXXX;
                                      YYY=FINYYY;
                                      wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                      tView.setText(String.valueOf(XXX + "  " + YYY));
                                      Log.d("total_count%esti>=100", " " + XXX + " " + YYY);
                                  }else{
                                      XXX=PDRXXXT;
                                      YYY=PDRYYYT;
                                      wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                      tView.setText(String.valueOf(XXX + "  " + YYY));
                                      Log.d("total_count%esti else", " " + XXX + " " + YYY);
                                  }


                            }else{
                                  XXX=XXX+PDRXXX;
                                  YYY=YYY+PDRYYY;
                                 // tView.setText(String.valueOf(XXX+"  "+YYY));
                                  wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                  Log.d("total_count%", " " + XXX + " " + YYY);
                              }

                            *///finish 지문인식 결합합


                           /* if(sTart==1) {
                                XXX= XXX + (int) averx;
                                Log.d("LXXX", "" + XXX);
                                YYY = YYY + (int) avery;
                                Log.d("LYYY", "" + YYY);

                                wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                sTart=0;
                            }else{
                                XXX = XXX + (int) averx;
                                Log.d("LXXX", "" + XXX);
                                YYY = YYY + (int) avery;
                                Log.d("LYYY", "" + YYY);

                                wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                            }*/
                         /*   if ((total_count % 20) == 0) {
                                FinalEstimatedXY = new double[2];
                                FinalEstimated = new double[2];

                                FINXXX = 0;
                                FINYYY = 0;
                                FinalEstimatedXY = finalEstimated();
                                FINXXX = FinalEstimated[0]*250/4;
                                FINYYY = FinalEstimated[1]*250/4;
                                Log.d("FINALESTIMATED", "" + FinalEstimated[0]+""+FinalEstimated[1]);
                                estimated=Math.sqrt(Math.pow((PDRXXX-FINXXX),2)+Math.pow((PDRYYY-FINYYY),2));
                                if(estimated>=(300/4))
                                {
                                    XXX=FINXXX;
                                    YYY=FINYYY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                    Log.d("EEE"," "+XXX+" "+YYY);
                                    //Log.d("YYYE"," "+YYY);
                                }else{
                                    XXX=PDRXXX;
                                    YYY=PDRYYY;
                                    wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                    Log.d("XXXE1"," "+XXX);
                                    Log.d("YYYE1"," "+YYY);
                                }
                            }else{
                                FINXXX = 0;
                                FINYYY = 0;
                                FinalEstimatedXY = finalEstimated();
                                FINXXX = FinalEstimated[0]*250/4;
                                FINYYY = FinalEstimated[1]*250/4;
                                Log.d("FINALESTIMATED", "" + FinalEstimated[0]+""+FinalEstimated[1]);
                                estimated=Math.sqrt(Math.pow((PDRXXX-FINXXX),2)+Math.pow((PDRYYY-FINYYY),2));
                                XXX=PDRXXX;
                                YYY=PDRYYY;
                                wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                            }*/

                            //Log.d("최종값Y", "" + YYY);Thread worker = new Thread() {
                            //data => server로 옮기기(재형)
                            // data = ID + " " + PDRXXX + " " + PDRYYY;

                            cc = 0;
                        }
                    }

                }

                // tView.setText(String.valueOf(anglex));
                tView1.setText(String.valueOf(total_count + ptotal_count + ptotal_count42 + rtotal_count));
                //20170818//20170823
            }else if(floorLevel==0||floorLevel==2||floorLevel==3 || floorLevel==4||floorLevel==5||floorLevel==6 || floorLevel==7||floorLevel==9||floorLevel==10||floorLevel==11){
                if(fingerPrintingVlue<100){
                    if(fingerPrintingVlue==0) {
                        Log.d("fingerPrintingValue1", "" + fingerPrintingVlue);
                        refreshFloor();
                    }
                            fingerPrintingVlue++; // 앱 시작과 동시에 핸들러에 메세지 전달



              }else if(fingerPrintingVlue>=100){
                    //20170818
                    floorChecker();
                    Log.d("fingerPrintingValue",""+BmaxBeaconIndex+" "+maxBeaconIndex);
                    if(((BmaxBeaconIndex!=maxBeaconIndex)&&(maxBeaconIndex!=0))||(fingerPrintDelayValue==100)){

                            fingerPrintingVlue=0;
                            fingerPrintDelayValue=0;

                            //floorChecker();
                            if(FD==1){
                                FloorDecision();
                            }
                            if(floorLevel!=BfloorLevel){
                                //floor decision
                                refBeacon();
                                MapCalling();

                            }
                            Log.d("MAP"," "+Map);
                            double FinalEstimatedPositionX = 0;
                            double FinalEstimatedPositionY = 0;
                            FinalEstimated[0] = FinalEstimatedPositionX;
                            FinalEstimated[1] = FinalEstimatedPositionY;
                            finalEstimated();
                            XXX=FinalEstimated[0];
                            YYY=FinalEstimated[1];
                            Log.d("fingerPrintingValue2",""+XXX+" "+YYY);


                            DelayPositionSend(XXX,YYY);
                            BmaxBeaconIndex=maxBeaconIndex;


                }else{
                        fingerPrintDelayValue++;

                    }
              }
            }//state==1 finish//
            //i++;


// angle Count(pitch), 앞주머니
         /*   if (countState == 0 || countState == 2) {

                if (previousPitchDetect == 0 && pc == 0 && pk == 0 && pl == 0 && pll == 0) {
                    if (-90 > quaternionPitch && quaternionPitch >= -150 || 40 <= quaternionPitch && quaternionPitch < 90) {
                        previousPitchDetect = 1;
                        if (anp1 > quaternionPitch) {
                            previousPitchDetect = 0;
                            psB = timeStamp;
                            anp1 = quaternionPitch;
                            minpB = quaternionPitch;

                        }
                    }

                }//간단 P 최솟 값
                if (pc == 0 && pk == 0 && pl == 0 && pll == 0) {
                    if (-40 >= quaternionPitch && quaternionPitch >= -90 || 90 <= quaternionPitch && quaternionPitch <= 140) {
                        pc = 1;
                        pd = 1;
                        if (currentAnglePitch < quaternionPitch) {
                            pc = 0;
                            pitchStart = timeStamp;
                            currentAnglePitch = quaternionPitch;
                            maxp = quaternionPitch;

                        }
                    }

                }//간단 P 최댓 값

                if (pc == 1 && pk == 0 && pl == 0 && pll == 0) {
                    if (-90 > quaternionPitch && quaternionPitch >= -150 || 40 <= quaternionPitch && quaternionPitch < 90) {
                        pk = 1;

                        if (currentAnglePitch > quaternionPitch) {
                            pk = 0;
                            pitchMiddle = timeStamp;
                            currentAnglePitch = quaternionPitch;
                            minp = quaternionPitch;
                        }
                    }
                }//간단 P 최솟 값

                if (pc == 1 && pk == 1 && pl == 0 && pll == 0)                                                                                        //간단 P 2번째 최댓 값

                if (pc == 1 && pk == 1 && pl == 1 && pll == 0) {
                    if (-90 > quaternionPitch && quaternionPitch >= -150 || 40 <= quaternionPitch && quaternionPitch < 90) {
                        pll = 1;
                        if (currentAnglePitch > quaternionPitch) {
                            pll = 0;
                            lastPitchEnd = timeStamp;
                            currentAnglePitch = quaternionPitch;
                            lminp = quaternionPitch;
                        }
                    }
                }//간단 P 2번째 최솟값
                if (pc == 1 && pk == 1 && pl == 1 && pll == 1) {

                    pcn = 1;

                }
                if (pc == 1 && pk == 1 && pl == 1 && pll == 1 && pcn == 1) {
                    if (previousPitchDetect == 0) {
                        if (200 < (pitchMiddle - pitchStart) && (pitchMiddle - pitchStart) < 1000) {//첫 번째 걸음 두 번째 걸음 비교 시간
                            if (200 < (pitchEnd - pitchMiddle) && (pitchEnd - pitchMiddle) < 1000) {//두 번째 걸음 세 번째 걸음 시간 비교
                                if (0 <= Math.abs(lmaxp - maxp) && Math.abs(lmaxp - maxp) <= 20) {//첫 번째 걸음 세 번째 걸음 최대값 비교
                                    if (200 < (lastPitchEnd - pitchEnd) && (lastPitchEnd - pitchEnd) < 1000) {//마지막이 틀리면 여기서 numbL 주자
                                        if (0 <= Math.abs(lminp - minp) && Math.abs(lminp - minp) <= 20) {//최소값 비교
                                            pckl = 1;
                                        } else {
                                            pckl = 1;
                                            numLp = 1;
                                        }//최소값 비교 틀림
                                    } else {
                                        pckl = 1;
                                        numLp = 1;
                                    }//마지막 비교 시간이 틀림
                                } else {//첫 번째, 세 번째 걸음 최대값 비교 틀림
                                    pdm++;
                                }
                            } else { //두 번째 걸음 세 번째 걸음 시간 비교 틀림
                                pdm++;
                            }
                        } else {//첫 번째 걸음 두 번째 걸음 비교 틀림
                            pdm++;
                        }

                    } else if (previousPitchDetect == 1) {

                        if (200 < (pitchMiddle - pitchStart) && (pitchMiddle - pitchStart) < 1000) {//첫 번째 걸음 두 번째 걸음 비교 시간
                            if (200 < (pitchEnd - pitchMiddle) && (pitchEnd - pitchMiddle) < 1000) {//두 번째 걸음 세 번째 걸음 시간 비교
                                if (0 <= Math.abs(lmaxp - maxp) && Math.abs(lmaxp - maxp) <= 20) {//첫 번째 걸음 세 번째 걸음 최대값 비교
                                    if (200 < (lastPitchEnd - pitchEnd) && (lastPitchEnd - pitchEnd) < 1000) {//마지막이 틀리면 여기서 numbL 주자
                                        if (0 <= Math.abs(lminp - minp) && Math.abs(lminp - minp) <= 20) {//최소값 비교
                                            if (200 < (pitchStart - psB) && (pitchStart - psB) < 1000) {//첫 번째 걸음 이전에 걸음이라고 생각되는 것 발견시 첫 번째 걸음 비교 시간
                                                pckl = 1;
                                                numBp = 1;
                                            } else {
                                                pckl = 1;
                                            }
                                        } else {
                                            pckl = 1;
                                            numLp = 1;
                                        }//최소값 비교 틀림
                                    } else {
                                        pckl = 1;
                                        numLp = 1;
                                    }//마지막 비교 시간이 틀림
                                } else {//첫 번째, 세 번째 걸음 최대값 비교 틀림
                                    pdm++;
                                }
                            } else { //두 번째 걸음 세 번째 걸음 시간 비교 틀림
                                pdm++;
                            }
                        } else {//첫 번째 걸음 두 번째 걸음 비교 틀림
                            pdm++;
                        }
                    } else {
                        pdm++;
                    }//previousPitchDetect==0,1 둘다 아닐 때 (이럴일 없지만 혹시나)


                    if (pckl == 1 && pdm == 0) {
                        if (ptotal_count == 0 || pd == 1) {
                            ptotal_count = ptotal_count + 4 + numBp - numLp;
                            pcount = pcount + 4 + numBp - numLp;


                            cc = 4 + numBp - numLp;
                            ptc = 1;

                            previousPitchDetect = 0;
                            numBp = 0;
                            psB = 0;
                            minpB = 0;
                            numLp = 0;

                            pitchStart = 0;
                            pitchStart = pitchEnd;
                            maxp = 0;
                            maxp = lmaxp;

                            pitchMiddle = 0;
                            pitchMiddle = lastPitchEnd;
                            minp = 0;
                            minp = lminp;


                            pcn = 0;
                            pckl = 0;

                            pdm = 0;
                            pd = 0;

                            countState = 2;


                        } else if (ptotal_count > 0 && pd == 0) {
                            ptotal_count = ptotal_count + 2 - numLp;
                            pcount = pcount + 2 - numLp;

                            cc = 2 - numLp;
                            ptc = 1;

                            previousPitchDetect = 0;
                            numBp = 0;
                            psB = 0;
                            minpB = 0;
                            numLp = 0;

                            pitchStart = 0;
                            pitchStart = pitchEnd;
                            maxp = 0;
                            maxp = lmaxp;

                            pitchMiddle = 0;
                            pitchMiddle = lastPitchEnd;
                            minp = 0;
                            minp = lminp;


                            pcn = 0;
                            pckl = 0;

                            pdm = 0;
                            pd = 0;

                            countState = 2;


                        }
                    } else {

                        previousPitchDetect = 0;
                        numBp = 0;
                        psB = 0;
                        minpB = 0;
                        numLp = 0;

                        pc = 0;
                        pitchStart = 0;
                        maxp = 0;

                        pk = 0;
                        pitchMiddle = 0;
                        minp = 0;

                        pl = 0;
                        pitchEnd = 0;
                        lmaxp = 0;

                        pll = 0;
                        lastPitchEnd = 0;
                        lminp = 0;

                        currentAnglePitch = -180;
                        pcn = 0;
                        pckl = 0;

                        pdm = 0;
                        pd = 0;
                        ptc = 0;
                        cc = 0;

                        countState = 0;

                    }
                    if (ptc == 1) {
                        ptc = 0;

                        pl = 0;
                        pitchEnd = 0;
                        lmaxp = 0;

                        pll = 0;
                        lastPitchEnd = 0;
                        lminp = 0;

                        double rad = Math.toRadians(anglex + 30);

                        averx = 60 * sin(rad);


                        Log.d(Tag, " " + averx);
                        avery = 60 * cos(rad);


                        plc = 1;
                        if ((averx > 4 || avery > 4 || averx < -4 || avery < -4) && plc == 1) {
                            plc = 0;
                            averageX = averageX / 4;
                            averx = cc * averx / 4;
                            PDRXXX = PDRXXX + (int) averx;

                            averageY = averageY / 4;
                            avery = cc * avery / 4;
                            PDRYYY = PDRYYY + (int) avery;
                            //  wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                            cc = 0;
                        }
                    }
                }
                // tView.setText(String.valueOf(ptotal_count));
                tView1.setText(String.valueOf(total_count + ptotal_count + ptotal_count42 + rtotal_count));
            }// state==2

//state ==3
*/

          /*  if (countState == 0 || countState == 3) {

                if (-90 <= quaternionPitch && quaternionPitch <= 90) {
                    if (pB3 == 0 && pc3 == 0 && pk3 == 0 && pl3 == 0 && pll3 == 0) {
                        if ((0 > quaternionPitch && quaternionPitch >= -90)) {
                            pB3 = 1;
                            if (anp13 > quaternionPitch) {
                                pB3 = 0;
                                psB3 = timeStamp;
                                anp13 = quaternionPitch;
                                minpB3 = quaternionPitch;

                            }
                        }

                    }//간단 P 최솟 값
                    if (pc3 == 0 && pk3 == 0 && pl3 == 0 && pll3 == 0) {
                        if ((0 <= quaternionPitch && quaternionPitch < 90)) {
                            pc3 = 1;
                            pd3 = 1;
                            if (maxp3 < quaternionPitch) {
                                pc3 = 0;
                                pd3 = 0;
                                ps3 = timeStamp;
                                anp3 = quaternionPitch;
                                maxp3 = quaternionPitch;

                            }
                        }

                    }//간단 P 최댓 값?

                    if (pc3 == 1 && pk3 == 0 && pl3 == 0 && pll3 == 0) {
                        if ((0 > quaternionPitch && quaternionPitch >= -90)) {
                            pk3 = 1;
                            if (minp3 > quaternionPitch) {
                                pk3 = 0;
                                pm3 = timeStamp;
                                anp3 = quaternionPitch;
                                minp3 = quaternionPitch;
                            }
                        }
                    }//간단 P 최솟 값

                    if (pc3 == 1 && pk3 == 1 && pl3 == 0 && pll3 == 0) {
                        if ((0 <= quaternionPitch && quaternionPitch < 90)) {
                            pl3 = 1;
                            if (lmaxp3 < quaternionPitch) {
                                pl3 = 0;
                                pe3 = timeStamp;
                                anp3 = quaternionPitch;
                                lmaxp3 = quaternionPitch;
                            }
                        }
                    }//간단 P 2번째 최댓 값

                    if (pc3 == 1 && pk3 == 1 && pl3 == 1 && pll3 == 0) {
                        if ((0 > quaternionPitch && quaternionPitch >= -90)) {
                            pll3 = 1;
                            if (lminp3 > quaternionPitch) {
                                pll3 = 0;
                                lpe3 = timeStamp;
                                anp3 = quaternionPitch;
                                lminp3 = quaternionPitch;
                            }
                        }
                    }//간단 P 2번째 최솟값
                    if (pc3 == 1 && pk3 == 1 && pl3 == 1 && pll3 == 1) {
                        pcn3 = 1;

                    }


                    if (pc3 == 1 && pk3 == 1 && pl3 == 1 && pll3 == 1 && pcn3 == 1) {
                        if (pB3 == 0) {//첫 번째 걸음 전에 걸음 없을 시
                            // pckl = 1;
                            if ((200 < (pm3 - ps3) && (pm3 - ps3) < 1000)) { //첫 번째 걸음과 두 번째 걸음 시간 비교
                                // pckl3 = 1;
                                if ((200 < (pe3 - pm3) && (pe3 - pm3) < 1000)) {//두 번째 걸음과 세 번째 걸음 시간 비교
                                    if (0 <= Math.abs(lmaxp - maxp) && Math.abs(lmaxp - maxp) < 20) {
                                        if ((200 < (lpe3 - pe3) && (lpe3 - pe3) < 1000)) {//세 번째 걸음과 네 번째 걸음 시간 비교
                                            pckl3 = 1;
                                        } else {
                                            pckl3 = 1;
                                            numLp3 = 1;
                                        }
                                    } else {
                                        pdm3++;
                                    }  // pckl=1;
                                } else {
                                    pdm3++;
                                }
                            } else {
                                pdm3++;
                            }

                        } else if (pB3 == 1) {// 첫 번째 걸음 전에 걸음이 있을 시
                            //pckl3 = 1;
                            if ((200 < (pm3 - ps3) && (pm3 - ps3) < 1000)) {
                                // pckl=1;
                                if ((200 < (pe3 - pm3) && (pe3 - pm3) < 1000)) {
                                    if (0 <= Math.abs(lmaxp - maxp) && Math.abs(lmaxp - maxp) < 20) {
                                        if ((200 < (lpe3 - pe3) && (lpe3 - pe3) < 1000)) {
                                            if ((200 < (ps3 - psB3) && (ps3 - psB3) < 1000)) {
                                                numBp3 = 1;
                                                pckl3 = 1;
                                            } else {
                                                pckl3 = 1;
                                                numBp3 = 0;
                                            }
                                            //  numBp=1;
                                            //pckl = 1;
                                        } else {
                                            pckl3 = 1;
                                            numLp3 = 1;

                                        }
                                    } else {
                                        pdm3++;
                                    }
                                } else {
                                    pdm3++;
                                }
                            } else {
                                pdm3++;
                            }

                        } else {
                            pdm3++;
                        }
                        // pckl=1;
//counting 부분

                        if (pckl3 == 1 && pdm3 == 0) {
                            if (ptotal_count42 == 0 || pd3 == 1) {
                                ptotal_count42 = ptotal_count42 + 4 + numBp3 - numLp3;
                                pcount42 = pcount42 + 4 + numBp3 - numLp3;


                                cc = 4 + numBp3 - numLp3;
                                ptc3 = 1;

                                pB3 = 0;
                                numBp3 = 0;
                                psB3 = 0;
                                minpB3 = 0;
                                numLp3 = 0;

                                ps3 = 0;
                                ps3 = pe3;
                                maxp3 = 0;
                                maxp3 = lmaxp3;

                                pm3 = 0;
                                pm3 = lpe3;
                                minp3 = 0;
                                minp3 = lminp3;


                                pcn3 = 0;
                                pckl3 = 0;

                                pdm3 = 0;
                                pd3 = 0;

                                countState = 3;


                            } else if (ptotal_count42 > 0 && pd3 == 0) {
                                ptotal_count42 = ptotal_count42 + 2 - numLp3;
                                pcount42 = pcount42 + 2 - numLp3;

                                cc = 2 - numLp3;
                                ptc3 = 1;

                                pB3 = 0;
                                numBp3 = 0;
                                psB3 = 0;
                                minpB3 = 0;
                                numLp3 = 0;

                                ps3 = 0;
                                ps3 = pe3;
                                maxp3 = 0;
                                maxp3 = lmaxp3;

                                pm3 = 0;
                                pm3 = lpe3;
                                minp3 = 0;
                                minp3 = lminp3;


                                pcn3 = 0;
                                pckl3 = 0;

                                pdm3 = 0;
                                pd3 = 0;

                                countState = 3;


                            }
                        } else {

                            pB3 = 0;
                            numBp3 = 0;
                            psB3 = 0;
                            minpB3 = 0;
                            numLp3 = 0;

                            pc3 = 0;
                            ps3 = 0;
                            maxp3 = 0;

                            pk3 = 0;
                            pm3 = 0;
                            minp3 = 0;

                            pl3 = 0;
                            pe3 = 0;
                            lmaxp3 = 0;

                            pll3 = 0;
                            lpe3 = 0;
                            lminp3 = 0;

                            anp13 = 180;
                            anp3 = -180;
                            pcn3 = 0;
                            pckl3 = 0;

                            pdm3 = 0;
                            pd3 = 0;
                            ptc3 = 0;
                            cc = 0;

                            countState = 0;

                        }
                        if (ptc3 == 1) {
                            ptc3 = 0;

                            pl3 = 0;
                            pe3 = 0;
                            lmaxp3 = 0;

                            pll3 = 0;
                            lpe3 = 0;
                            lminp3 = 0;

                            double rad = Math.toRadians(anglex + 30);

                            averx = 60 * sin(rad);


                            Log.d(Tag, " " + averx);
                            avery = 60 * cos(rad);


                            plc3 = 1;
                            if ((averx > 4 || avery > 4 || averx < -4 || avery < -4) && plc == 1) {
                                plc3 = 0;
                                averageX = averageX / 4;
                                averx = cc * averx / 4;
                                PDRXXX = PDRXXX + (int) averx;

                                averageY = averageY / 4;
                                avery = cc * avery / 4;
                                PDRYYY = PDRYYY + (int) avery;
                                // wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                cc = 0;
                            }
                        }
                    }
                    // tView.setText(String.valueOf(ptotal_count));
                    tView1.setText(String.valueOf(total_count + ptotal_count + ptotal_count42 + rtotal_count));
                } else {

                    if (pB42 == 0 && pc42 == 0 && pk42 == 0 && pl42 == 0 && pll42 == 0) {
                        if ((175 > transformedQuaternionPitch && transformedQuaternionPitch >= 90)) {
                            pB42 = 1;
                            if (anp142 > transformedQuaternionPitch) {
                                pB42 = 0;
                                psB42 = timeStamp;
                                anp142 = transformedQuaternionPitch;
                                minpB42 = transformedQuaternionPitch;

                            }
                        }

                    }//간단 P 최솟 값
                    if (pc42 == 0 && pk42 == 0 && pl42 == 0 && pll42 == 0) {
                        if ((175 <= transformedQuaternionPitch && transformedQuaternionPitch < 260)) {
                            pc42 = 1;
                            pd42 = 1;
                            if (maxp42 < transformedQuaternionPitch) {
                                pc42 = 0;
                                pd42 = 0;
                                ps42 = timeStamp;
                                anp42 = transformedQuaternionPitch;
                                maxp42 = transformedQuaternionPitch;

                            }
                        }

                    }//간단 P 최댓 값?

                    if (pc42 == 1 && pk42 == 0 && pl42 == 0 && pll42 == 0) {
                        if ((175 > transformedQuaternionPitch && transformedQuaternionPitch >= 90)) {
                            pk42 = 1;
                            if (minp42 > transformedQuaternionPitch) {
                                pk42 = 0;
                                pm42 = timeStamp;
                                anp42 = transformedQuaternionPitch;
                                minp42 = transformedQuaternionPitch;
                            }
                        }
                    }//간단 P 최솟 값

                    if (pc42 == 1 && pk42 == 1 && pl42 == 0 && pll42 == 0) {
                        if ((175 <= transformedQuaternionPitch && transformedQuaternionPitch < 260)) {
                            pl42 = 1;
                            if (lmaxp42 < transformedQuaternionPitch) {
                                pl42 = 0;
                                pe42 = timeStamp;
                                anp42 = transformedQuaternionPitch;
                                lmaxp42 = transformedQuaternionPitch;
                            }
                        }
                    }//간단 P 2번째 최댓 값

                    if (pc42 == 1 && pk42 == 1 && pl42 == 1 && pll42 == 0) {
                        if ((175 > transformedQuaternionPitch && transformedQuaternionPitch >= 90)) {
                            pll42 = 1;
                            if (lminp42 > transformedQuaternionPitch) {
                                pll42 = 0;
                                lpe42 = timeStamp;
                                anp42 = transformedQuaternionPitch;
                                lminp42 = transformedQuaternionPitch;
                            }
                        }
                    }//간단 P 2번째 최솟값
                    if (pc42 == 1 && pk42 == 1 && pl42 == 1 && pll42 == 1) {
                        pcn42 = 1;

                    }


                    if (pc42 == 1 && pk42 == 1 && pl42 == 1 && pll42 == 1 && pcn42 == 1) {
                        if (pB42 == 0) {//첫 번째 걸음 전에 걸음 없을 시
                            // pckl = 1;
                            if ((200 < (pm42 - ps42) && (pm42 - ps42) < 1000)) { //첫 번째 걸음과 두 번째 걸음 시간 비교
                                // pckl3 = 1;
                                if ((200 < (pe42 - pm42) && (pe42 - pm42) < 1000)) {//두 번째 걸음과 세 번째 걸음 시간 비교
                                    if ((200 < (lpe42 - pe42) && (lpe42 - pe42) < 1000)) {//세 번째 걸음과 네 번째 걸음 시간 비교
                                        pckl42 = 1;
                                    } else {
                                        pckl42 = 1;
                                        numLp42 = 1;
                                    }
                                    // pckl=1;
                                } else {
                                    pdm42++;
                                }
                            } else {
                                pdm42++;
                            }

                        } else if (pB42 == 1) {// 첫 번째 걸음 전에 걸음이 있을 시
                            //pckl3 = 1;
                            if ((200 < (pm42 - ps42) && (pm42 - ps42) < 1000)) {
                                // pckl=1;
                                if ((200 < (pe42 - pm42) && (pe42 - pm42) < 1000)) {
                                    if ((200 < (lpe42 - pe42) && (lpe42 - pe42) < 1000)) {
                                        if ((200 < (ps42 - psB42) && (ps42 - psB42) < 1000)) {
                                            numBp42 = 1;
                                            pckl42 = 1;
                                        } else {
                                            pckl42 = 1;
                                            numBp42 = 0;
                                        }
                                        //  numBp=1;
                                        //pckl = 1;
                                    } else {
                                        pckl42 = 1;
                                        numLp42 = 1;

                                    }
                                } else {
                                    pdm42++;
                                }
                            } else {
                                pdm42++;
                            }

                        } else {
                            pdm42++;
                        }

//counting 부분

                        if (pckl42 == 1 && pdm42 == 0) {
                            if (ptotal_count42 == 0 || pd42 == 1) {
                                ptotal_count42 = ptotal_count42 + 4 + numBp42 - numLp42;
                                pcount42 = pcount42 + 4 + numBp42 - numLp42;


                                cc = 4 + numBp42 - numLp42;
                                ptc42 = 1;

                                pB42 = 0;
                                numBp42 = 0;
                                psB42 = 0;
                                minpB42 = 0;
                                numLp42 = 0;

                                ps42 = 0;
                                ps42 = pe42;
                                maxp42 = 0;
                                maxp42 = lmaxp42;

                                pm42 = 0;
                                pm42 = lpe42;
                                minp42 = 0;
                                minp42 = lminp42;


                                pcn42 = 0;
                                pckl42 = 0;

                                pdm42 = 0;
                                pd42 = 0;

                                countState = 3;


                            } else if (ptotal_count42 > 0 && pd42 == 0) {
                                ptotal_count42 = ptotal_count42 + 2 - numLp42;
                                pcount42 = pcount42 + 2 - numLp42;

                                cc = 2 - numLp42;
                                ptc42 = 1;

                                pB42 = 0;
                                numBp42 = 0;
                                psB42 = 0;
                                minpB42 = 0;
                                numLp42 = 0;

                                ps42 = 0;
                                ps42 = pe42;
                                maxp42 = 0;
                                maxp42 = lmaxp42;

                                pm42 = 0;
                                pm42 = lpe42;
                                minp42 = 0;
                                minp42 = lminp42;


                                pcn42 = 0;
                                pckl42 = 0;

                                pdm42 = 0;
                                pd42 = 0;

                                countState = 3;


                            }
                        } else {

                            pB42 = 0;
                            numBp42 = 0;
                            psB42 = 0;
                            minpB42 = 0;
                            numLp42 = 0;

                            pc42 = 0;
                            ps42 = 0;
                            maxp42 = 0;

                            pk42 = 0;
                            pm42 = 0;
                            minp42 = 0;

                            pl42 = 0;
                            pe42 = 0;
                            lmaxp42 = 0;

                            pll42 = 0;
                            lpe42 = 0;
                            lminp42 = 0;

                            anp142 = 180;
                            anp42 = -180;
                            pcn42 = 0;
                            pckl42 = 0;

                            pdm42 = 0;
                            pd42 = 0;
                            ptc42 = 0;
                            cc = 0;

                            countState = 0;

                        }
                        if (ptc42 == 1) {
                            ptc42 = 0;

                            pl42 = 0;
                            pe42 = 0;
                            lmaxp42 = 0;

                            pll42 = 0;
                            lpe42 = 0;
                            lminp42 = 0;

                            double rad = Math.toRadians(anglex + 30);

                            averx = 60 * sin(rad);


                            Log.d(Tag, " " + averx);
                            avery = 60 * cos(rad);


                            plc = 1;
                            if ((averx > 4 || avery > 4 || averx < -4 || avery < -4) && plc == 1) {
                                plc = 0;
                                averageX = averageX / 4;
                                averx = cc * averx / 4;
                                PDRXXX = PDRXXX + (int) averx;

                                averageY = averageY / 4;
                                avery = cc * avery / 4;
                                PDRYYY = PDRYYY + (int) avery;
                                // wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                                cc = 0;
                            }
                        }
                    }
                    // tView.setText(String.valueOf(ptotal_count));
                    tView1.setText(String.valueOf(total_count + ptotal_count + ptotal_count42 + rtotal_count));

                }
            }*/
//angle count roll state==4
        /*    if (countState == 0 || countState == 4) {
                if (rB == 0 && rc == 0 && rk == 0 && rl == 0 && rll == 0) {
                    if (-30 <= quaternionRoll && quaternionRoll < 0) {
                        rB = 1;
                        if (anr1 > quaternionRoll) {
                            rB = 0;
                            rsB = timeStamp;
                            anr1 = quaternionRoll;
                            minrB = quaternionRoll;

                        }
                    }

                }//간단 R 최솟 값

                if (rc == 0 && rk == 0 && rl == 0 && rll == 0) {
                    if (0 <= quaternionRoll && quaternionRoll <= 30) {
                        rc = 1;
                        rd = 1;
                        if (anr < quaternionRoll) {
                            rc = 0;
                            rs = timeStamp;
                            anr = quaternionRoll;
                            maxr = quaternionRoll;

                        }
                    }

                }//간단 R 최댓 값

                if (rc == 1 && rk == 0 && rl == 0 && rll == 0) {
                    if (-30 <= quaternionRoll && quaternionRoll < 0) {
                        rk = 1;

                        if (anr > quaternionRoll) {
                            rk = 0;
                            rm = timeStamp;
                            anr = quaternionRoll;
                            minr = quaternionRoll;
                        }
                    }
                }//간단 R 최솟 값

                if (rc == 1 && rk == 1 && rl == 0 && rll == 0) {
                    if (0 <= quaternionRoll && quaternionRoll <= 30) {
                        rl = 1;
                        if (anr < quaternionRoll) {
                            rl = 0;
                            re = timeStamp;
                            anr = quaternionRoll;
                            lmaxr = quaternionRoll;
                        }
                    }
                }//간단 R 2번째 최댓 값

                if (rc == 1 && rk == 1 && rl == 1 && rll == 0) {
                    if (-30 <= quaternionRoll && quaternionRoll < 0) {
                        rll = 1;
                        if (anr > quaternionRoll) {
                            rll = 0;
                            lre = timeStamp;
                            anr = quaternionRoll;
                            lminr = quaternionRoll;
                        }
                    }
                }//간단 R 2번째 최솟값

                if (rc == 1 && rk == 1 && rl == 1 && rll == 1) {

                    rcn = 1;

                }

                if (rc == 1 && rk == 1 && rl == 1 && rll == 1 && rcn == 1) {
                    if (rB == 0) {
                        if ((200 < rm - rs) && (rm - rs < 1000)) {
                            if ((10 < Math.abs(maxr - minr)) && (Math.abs(maxr - minr) < 40)) {
                                if ((10 < Math.abs(lmaxr - lminr)) && Math.abs(lmaxr - lminr) < 40) {
                                    if ((200 < lre - re) && (lre - re < 1000)) {
                                        rckl = 1;
                                    } else {
                                        rdm++;
                                    }
                                } else {
                                    rdm++;
                                }
                            } else {
                                rdm++;
                            }
                        } else {
                            rdm++;
                        }
                    } else if (rB == 1) {
                        if ((200 < rm - rs) && (rm - rs < 1000)) {
                            if ((10 < Math.abs(maxr - minr)) && (Math.abs(maxr - minr) < 40)) {
                                if ((10 < Math.abs(lmaxr - lminr)) && Math.abs(lmaxr - lminr) < 40) {
                                    // if(0<=Math.abs(lmaxp-maxp)&&Math.abs(lmaxp-maxp)<= 5){
                                    if ((200 < lre - re) && (lre - re < 1000)) {
                                        if ((200 < rs - rsB) && (rs - rsB < 1000)) {
                                            if (0 <= Math.abs(minr - minrB) && Math.abs(minr - minrB) <= 20) {
                                                numBr = 1;

                                            }
                                        }
                                        //if(0<=Math.abs(lminp-minp)&&Math.abs(lminp-minp)<= 5){
                                        pckl = 1;
                                    *//* }else*//**//* if(10<=Math.abs(lminp-minp)&&Math.abs(lminp-minp)<= 15){
                                         numL=1;
                                     }else{
                                         pdm++;
                                     }*//*
                                    } else if (6 <= Math.abs(lminr - minr) && Math.abs(lminr - minr) <= 10) {
                                        if ((200 < rs - rsB) && (rs - rsB < 1000)) {
                                            if (0 <= Math.abs(minr - minrB) && Math.abs(minr - minrB) <= 20) {
                                                numBr = 1;

                                            }
                                        }
                                        numLr = 1;
                                    } else {
                                        rdm++;

                                    }
                                } else {
                                    rdm++;
                                }
                            } else {
                                rdm++;
                            }
                        } else {
                            rdm++;

                        }

                    }

                    if (rckl == 1 && rdm == 0) {
                        if (rtotal_count == 0 || rd == 1) {
                            rtotal_count = rtotal_count + 4 + numBr - numLr;
                            rcount = rcount + 4 + numBp - numLp;


                            //cc = 4 ; //numBp - numLp;
                            rtc = 1;

                            rB = 0;
                            numBr = 0;
                            rsB = 0;
                            minrB = 0;
                            numLr = 0;

                            rs = 0;
                            rs = re;
                            maxr = 0;
                            maxr = lmaxr;

                            rm = 0;
                            rm = lre;
                            minr = 0;
                            minr = lminr;


                            rcn = 0;
                            rckl = 0;

                            rdm = 0;
                            rd = 0;

                            countState = 4;


                        } else if (rtotal_count > 0 && rd == 0) {
                            rtotal_count = rtotal_count + 2 - numLp;
                            rcount = rcount + 2 - numLp;

                            //cc = 2 ;//- numLp;
                            rtc = 1;

                            rB = 0;
                            numBr = 0;
                            rsB = 0;
                            minrB = 0;
                            numLr = 0;

                            rs = 0;
                            rs = re;
                            maxr = 0;
                            maxr = lmaxr;

                            rm = 0;
                            rm = lre;
                            minr = 0;
                            minr = lminr;


                            rcn = 0;
                            rckl = 0;

                            rdm = 0;
                            rd = 0;

                            countState = 4;


                        }
                    } else {

                        rB = 0;
                        numBr = 0;
                        rsB = 0;
                        minrB = 0;
                        numLr = 0;

                        rc = 0;
                        rs = 0;
                        maxr = 0;

                        rk = 0;
                        rm = 0;
                        minr = 0;

                        rl = 0;
                        re = 0;
                        lmaxr = 0;

                        rll = 0;
                        lre = 0;
                        lminr = 0;

                        anr1 = 90;
                        anr = -90;
                        rcn = 0;
                        rckl = 0;

                        rdm = 0;
                        rd = 0;
                        rtc = 0;
                        //cc = 0;

                        countState = 0;

                    }
                    if (rtc == 1) {
                        rtc = 0;

                        rl = 0;
                        re = 0;
                        lmaxr = 0;

                        rll = 0;
                        lre = 0;
                        lminr = 0;

                  *//*  double rad = Math.toRadians(anglex + 30);

                    averx = 60 * sin(rad);


                    Log.d(Tag, " " + averx);
                    avery = 60 * cos(rad);


                    plc = 1;
                    if ((averx > 4 || avery > 4 || averx < -4 || avery < -4) && plc == 1) {
                        plc = 0;
                        *//**//*averageX = averageX / 4;*//**//*
                        averx = cc * averx / 4;
                        XXX = XXX + (int) averx;

                        *//**//*averageY = averageY / 4;*//**//*
                        avery = cc * avery / 4;
                        YYY = YYY + (int) avery;
                        wvLayout0401v3.loadUrl("javascript:androidBridge (" + XXX + ", " + YYY + ",'#000000')");
                        cc = 0;
                    }*//*
                    }
                }
                tView1.setText(String.valueOf(total_count + ptotal_count + ptotal_count42 + rtotal_count));


            }*/
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void mOnClick(View v) {
        switch (v.getId()) {
            case R.id.resetBtn:
                total_count = 0;
                X = null;
                Y = null;
                Z = null;
                AX = null;
                AY = null;
                AZ = null;
                UP = null;
                QQY = null;
                QQP = null;
                QQR = null;
                RQY = null;

                angle2 = 0;
                quaternionYaw = 0;
                quaternionPitch = 0;
                quaternionRoll = 0;


                c = 0;
                maxiaz = 0;
                start = 0;
                de = 0;
                det = 0;
                cd = 0;
                cdd = 0;
                cddd = 0;
                accpzd = 0;

                k = 0;
                minaz = 0;
                mid = 0;
                dete = 0;
                detec = 0;
                cyd = 0;
                cydd = 0;
                cyddd = 0;
                accpzdd = 0;

                l = 0;
                lmaxiaz = 0;
                end = 0;
                detect = 0;
                tdetect = 0;
                cyyd = 0;
                cyydd = 0;
                cyyddd = 0;
                accpzddd = 0;
                accp = 0;

                d = 0;

                PDRXXX = 0;
                PDRYYY = 0;
                VALUE=0;
                smoothX=0;
                smoothY=0;


                input = 0;

                ss = 0;
                mm = 0;
                ee = 0;
                lee = 0;

                ptotal_count = 0;
                pcount = 0;

                anp1 = 180;
                previousPitchDetect = 0;
                numBp = 0;
                psB = 0;
                minpB = 0;

                pitchStart = 0;
                pc = 0;
                maxp = 0;

                pitchMiddle = 0;
                pk = 0;
                minp = 0;

                pitchEnd = 0;
                pl = 0;
                lmaxp = 0;

                lastPitchEnd = 0;
                pll = 0;
                lminp = 0;

                currentAnglePitch = -180;
                pcn = 0;
                pckl = 0;

                pdm = 0;
                pd = 0;
                ptc = 0;
                cc = 0;

                countState = 0;
//state==3 reset(-90~90)


                pB3 = 0;
                numBp3 = 0;
                psB3 = 0;
                minpB3 = 0;
                numLp3 = 0;

                pc3 = 0;
                ps3 = 0;
                maxp3 = 0;

                pk3 = 0;
                pm3 = 0;
                minp3 = 0;

                pl3 = 0;
                pe3 = 0;
                lmaxp3 = 0;

                pll3 = 0;
                lpe3 = 0;
                lminp3 = 0;

                anp13 = 180;
                anp3 = -180;
                pcn3 = 0;
                pckl3 = 0;

                pdm3 = 0;
                pd3 = 0;
                ptc3 = 0;
                cc = 0;


//state==3(90~260)
                ptotal_count42 = 0;
                pB42 = 0;
                numBp42 = 0;
                psB42 = 0;
                minpB42 = 0;
                numLp42 = 0;

                pc42 = 0;
                ps42 = 0;
                maxp42 = 0;

                pk42 = 0;
                pm42 = 0;
                minp42 = 0;

                pl42 = 0;
                pe42 = 0;
                lmaxp42 = 0;

                pll42 = 0;
                lpe42 = 0;
                lminp42 = 0;

                anp142 = 180;
                anp42 = -180;
                pcn42 = 0;
                pckl42 = 0;

                pdm42 = 0;
                pd42 = 0;
                ptc42 = 0;
                cc = 0;


//state==4 roll


                rtotal_count = 0;
                rcount = 0;

                anr1 = 90;
                rB = 0;
                numBr = 0;
                rsB = 0;
                minrB = 0;

                rs = 0;
                rc = 0;
                maxr = 0;

                rm = 0;
                rk = 0;
                minr = 0;

                re = 0;
                rl = 0;
                lmaxr = 0;

                lre = 0;
                rll = 0;
                lminr = 0;

                anr = -90;
                rcn = 0;
                rckl = 0;

                rdm = 0;
                rd = 0;

                //FingerPrint
                int RefCount = 0;
                int TetCount = 0;




                fis_Ref_Line=null;

                uuid=null;
                major=null;
                minor=null;
                TxPower=null;
                StringT1=null;




                //int IntTxPower;


                FINXXX=0;
                FINYYY=0;



                XXX=0;
                YYY=0;


                // tView.setText(String.valueOf(ptotal_count+" "+total_count));
                break;


        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {


        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(getApplication(), "되돌아가기 버튼이 클릭됨", Toast.LENGTH_SHORT).show();
        }
        if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            if (event.isLongPress()) {
                return true;
            }
            if (event.getKeyCode() != 0) {
                return true;
            }

            Toast.makeText(getApplication(), "메뉴 버튼이 클릭됨", Toast.LENGTH_SHORT).show();
        }
        return super.dispatchKeyEvent(event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      /*  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
        return true;
    }
}



