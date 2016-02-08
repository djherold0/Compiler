/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler;

/**
 * This is the parse parseTable
 * @author Dan Herold
 * @version 2014.5.7
 */
public final class ParseTable {
    
    public static final int[][] parseTable = new int[106][125];
    
    public ParseTable(){
        for(int i=0;i<parseTable.length;i++){
            for(int j=0; j<parseTable[i].length;j++){
                parseTable[i][j]=9999;
            }
        }
        
        /***************************************************************************/
        //state 0
        //fill the whole row with the default
        for(int i=0, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -3;
            }
        }
        //set the rest by hand
        parseTable[0][2] = 1;//DECLARE
        parseTable[0][101] = 2;//block
        parseTable[0][102] = 3;//declarations
        //state 1
        for(int i=1, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -5;
            }
        }
        parseTable[1][1] = 4;//id
        parseTable[1][103] = 5;//declare_rest go to state 5
        //state 2
        parseTable[2][41] = 6;//EOF; shift and go to state 6
        //state 3
        parseTable[3][13]=7;//BEGIN
        parseTable[3][110]=8;//compound_statement
        //state 4
        parseTable[4][5]=9;//BOOLEAN
        parseTable[4][6]=10;//CHAR
        parseTable[4][9]=11;//NUMBER
        parseTable[4][10]=12;//INT
        parseTable[4][11]=13;//SMALLINT
        parseTable[4][12]=14;//POSITIVE
        parseTable[4][105]=15;//data_type
        parseTable[4][106]=16;//characters
        parseTable[4][109]=17;//numbers
        //state 5
        for(int i=5, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -2;
            }
        }
        //state 6
        //accept is the default
        for(int i=6, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = 500;
            }
        }
        //state 7
        parseTable[7][1]=18;//id
        parseTable[7][13]=7;//BEGIN
        parseTable[7][15]=19;//NULL
        parseTable[7][16]=20;//DBMS_OUTPUT.PUT_LINE
        parseTable[7][17]=21;//DBMS_OUTPUT.PUT
        parseTable[7][18]=22;//DBMS_OUTPUT.NEW_LINE
        parseTable[7][19]=23;//&
        parseTable[7][20]=24;//IF
        parseTable[7][22]=25;//WHILE
        parseTable[7][110]=26;//compound_statement
        parseTable[7][111]=27;//optional_statements
        parseTable[7][112]=28;//statement_list
        parseTable[7][113]=29;//statement
        parseTable[7][114]=30;//lefthandside
        //state 8
        parseTable[8][0]=31;//$
        //state 9
        for(int i=9, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -10;
            }
        }
        //state 10
        for(int i=10, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -11;
            }
        }
        //state 11
        parseTable[11][39]=32;//(
        //state 12
        parseTable[12][39]=33;//(
        //state 13
        parseTable[13][39]=34;//(
        //state 14
        parseTable[14][39]=35;//(
        //state 15
        for(int i=15, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -7;
            }
        }
        parseTable[15][4]=36;//:=
        parseTable[15][104]=37;//default
        //state 16
        for(int i=16, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -8;
            }
        }
        //state 17
        for(int i=17, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -9;
            }
        }
        //state 18
        parseTable[18][4]=38;//:=
        //state 19
        parseTable[19][3]=39;//;
        //state 20
        parseTable[20][39]=40;//(
        //state 21
        parseTable[21][39]=41;//(
        //state 22
        for(int i=22, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -29;
            }
        }
        //state 23
        parseTable[23][1]=42;//id
        //state 24
        parseTable[24][1]=43;//id
        parseTable[24][7]=44;//num
        parseTable[24][15]=45;//NULL
        parseTable[24][25]=46;//TRUE
        parseTable[24][26]=47;//FALSE
        parseTable[24][27]=48;//NOT
        parseTable[24][116]=49;//expression; go to state 49
        parseTable[24][117]=50;//simple_expression
        parseTable[24][118]=51;//term
        parseTable[24][119]=52;//factor
        //state 25
        parseTable[25][1]=43;//id
        parseTable[25][7]=44;//num
        parseTable[25][15]=45;//NULL
        parseTable[25][25]=46;//TRUE
        parseTable[25][26]=47;//FALSE
        parseTable[25][27]=48;//NOT
        parseTable[25][116]=53;//expression
        parseTable[25][117]=50;//simple_expression
        parseTable[25][118]=51;//term
        parseTable[25][119]=52;//factor
        //state 26
        for(int i=26, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -26;
            }
        }
        //state 27
        parseTable[27][14]=54;//END
        //state 28
        for(int i=28, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -22;
            }
        }
        parseTable[28][3]=55;//;
        //state 29
        for(int i=29, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -23;
            }
        }
        //state 30
        for(int i=30, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -25;
            }
        }
        //state 31
        for(int i=31, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -1;
            }
        }
        //state 32
        for(int i=32, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -13;
            }
        }
        parseTable[32][7]=56;//num
        parseTable[32][107]=57;//size
        //state 33
        for(int i=33, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -13;
            }
        }
        parseTable[33][7]=56;//num
        parseTable[33][107]=58;//size
        //state 34
        for(int i=34, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -13;
            }
        }
        parseTable[34][7]=56;//num
        parseTable[34][107]=59;//size
        //state 35
        for(int i=35, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -13;
            }
        }
        parseTable[35][7]=56;//num
        parseTable[35][107]=60;//size
        //state 36
        parseTable[36][1]=43;//id
        parseTable[36][7]=44;//num
        parseTable[36][15]=45;//NULL
        parseTable[36][24]=61;//single character 'c'
        parseTable[36][25]=46;//TRUE
        parseTable[36][26]=47;//FALSE
        parseTable[36][27]=48;//NOT
        parseTable[36][115]=62;//righthandside
        parseTable[36][116]=63;//expression
        parseTable[36][117]=50;//simple_expression
        parseTable[36][118]=51;//term
        parseTable[36][119]=52;//factor
        //state 37
        parseTable[37][3]=64;//;
        //state 38
        parseTable[38][1]=43;//id
        parseTable[38][7]=44;//num
        parseTable[38][15]=45;//NULL
        parseTable[38][24]=61;//single character 'c'
        parseTable[38][25]=46;//TRUE
        parseTable[38][26]=47;//FALSE
        parseTable[38][27]=48;//NOT
        parseTable[38][115]=65;//righthandside
        parseTable[38][116]=63;//expression
        parseTable[38][117]=50;//simple_expression
        parseTable[38][118]=51;//term
        parseTable[38][119]=52;//factor
        //state 39
        for(int i=39, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -21;
            }
        }
        //state 40
        parseTable[40][1]=66;//id
        //state 41
        parseTable[41][1]=67;//id
        //state 42
        for(int i=42, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -30;
            }
        }
        //state 43
        for(int i=43, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -42;
            }
        }
        //state 44
        for(int i=44, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -43;
            }
        }
        //state 45
        for(int i=45, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -46;
            }
        }
        //state 46
        for(int i=46, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -44;
            }
        }
        //state 47
        for(int i=47, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -45;
            }
        }
        //state 48
        parseTable[48][1]=43;//id
        parseTable[48][7]=44;//num
        parseTable[48][15]=45;//NULL
        parseTable[48][25]=46;//TRUE
        parseTable[48][26]=47;//FALSE
        parseTable[48][27]=48;//NOT
        parseTable[48][104]=68;//factor
        //state 49
        parseTable[49][21]=69;//THEN
        //state 50
        for(int i=0;i<parseTable[50].length; i++){
            parseTable[50][i] = -36;
        }
        parseTable[50][28]=70;//>
        parseTable[50][29]=71;//>=
        parseTable[50][30]=72;//=
        parseTable[50][31]=73;//<=
        parseTable[50][32]=74;//<
        parseTable[50][33]=75;//<>
        parseTable[50][34]=76;//+
        parseTable[50][35]=77;//-
        parseTable[50][120]=78;//relop
        parseTable[50][121]=79;//addop
        //state 51
        for(int i=51, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -38;
            }
        }
        parseTable[51][36]=80;//*
        parseTable[51][37]=81;///
        parseTable[51][38]=82;//MOD
        parseTable[51][122]=83;//mulop
        //state 52
        for(int i=52, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -40;
            }
        }
        //state 53
        parseTable[53][23]=84;//LOOP
        //state 54
        parseTable[54][3]=85;//;
        //state 55
        parseTable[55][1]=18;//id
        parseTable[55][13]=7;//BEGIN
        parseTable[55][16]=20;//DBMS_OUTPUT.PUT_LINE
        parseTable[55][17]=21;//DBMS_OUTPUT.PUT
        parseTable[55][18]=22;//DBMS_OUTPUT.NEW_LINE
        parseTable[55][19]=23;//&
        parseTable[55][20]=24;//IF
        parseTable[55][22]=25;//WHILE
        parseTable[55][110]=26;//compound_statement
        parseTable[55][113]=86;//statement
        parseTable[55][114]=30;//lefthandside
        //state 56
        for(int i=56, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -15;
            }
        }
        parseTable[56][8]=87;//,
        parseTable[56][108]=88;//size_option
        //state 57
        parseTable[57][40]=89;//)
        //state 58
        parseTable[58][40]=90;//)
        //state 59
        parseTable[59][40]=91;//)
        //state 60
        parseTable[60][40]=92;//)
        //state 61
        for(int i=61, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -35;
            }
        }
        //state 62
        for(int i=62, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -6;
            }
        }
        //state 63
        for(int i=63, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -34;
            }
        }
        //state 64
        for(int i=64, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -5;
            }
        }
        parseTable[64][1]=4;//id
        parseTable[64][103]=93;//declare_rest
        //state 65
        for(int i=65, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -33;
            }
        }
        //state 66
        parseTable[66][40]=94;//)
        //state 67
        parseTable[67][40]=95;//)
        //state 68
        for(int i=68, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -47;
            }
        }
        //state 69
        parseTable[69][1]=18;//id
        parseTable[69][13]=7;//BEGIN
        parseTable[69][16]=20;//DBMS_OUTPUT.PUT_LINE
        parseTable[69][17]=21;//DBMS_OUTPUT.PUT
        parseTable[69][18]=22;//DBMS_OUTPUT.NEW_LINE
        parseTable[69][19]=23;//&
        parseTable[69][20]=24;//IF
        parseTable[69][22]=25;//WHILE
        parseTable[69][110]=26;//compound_statement
        parseTable[69][113]=96;//statement
        parseTable[69][114]=30;//lefthandside
        //state 70
        for(int i=70, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -48;
            }
        }
        //state 71
        for(int i=71, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -49;
            }
        }
        //state 72
        for(int i=72, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -50;
            }
        }
        //state 73
        for(int i=73, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -51;
            }
        }
        //state 74
        for(int i=74, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -52;
            }
        }
        //state 75
        for(int i=75, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -53;
            }
        }
        //state 76
        for(int i=76, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -54;
            }
        }
        //state 77
        for(int i=77, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -55;
            }
        }
        //state 78
        parseTable[78][1]=43;//id
        parseTable[78][7]=44;//num
        parseTable[78][15]=45;//NULL
        parseTable[78][25]=46;//TRUE
        parseTable[78][26]=47;//FALSE
        parseTable[78][27]=48;//NOT
        parseTable[78][117]=97;//simple_expression
        parseTable[78][118]=51;//term
        parseTable[78][119]=52;//factor
        //state 79
        parseTable[79][1]=43;//id
        parseTable[79][7]=44;//num
        parseTable[79][15]=45;//NULL
        parseTable[79][25]=46;//TRUE
        parseTable[79][26]=47;//FALSE
        parseTable[79][27]=48;//NOT
        parseTable[79][118]=98;//term
        parseTable[79][119]=52;//factor
        //state 80
        for(int i=80, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -56;
            }
        }
        //state 81
        for(int i=81, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -57;
            }
        }
        //state 82
        for(int i=82, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -58;
            }
        }
        //state 83
        parseTable[83][1]=43;//id
        parseTable[83][7]=44;//num
        parseTable[83][15]=45;//NULL
        parseTable[83][25]=46;//TRUE
        parseTable[83][26]=47;//FALSE
        parseTable[83][27]=48;//NOT
        parseTable[83][119]=99;//factor
        //state 84
        parseTable[84][1]=18;//id
        parseTable[84][13]=7;//BEGIN
        parseTable[84][16]=20;//DBMS_OUTPUT.PUT_LINE
        parseTable[84][17]=21;//DBMS_OUTPUT.PUT
        parseTable[84][18]=22;//DBMS_OUTPUT.NEW_LINE
        parseTable[84][19]=23;//&
        parseTable[84][20]=24;//IF
        parseTable[84][22]=25;//WHILE
        parseTable[84][110]=26;//compound_statement
        parseTable[84][113]=100;//statement
        parseTable[84][114]=30;//lefthandside
        //state 85
        for(int i=85, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -20;
            }
        }
        //state 86
        for(int i=86, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -24;
            }
        }
        //state 87
        parseTable[86][7]=101;//num
        //state 88
        for(int i=88, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -12;
            }
        }
        //state 89
        for(int i=89, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -16;
            }
        }
        //state 90
        for(int i=90, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -17;
            }
        }
        //state 91
        for(int i=91, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -18;
            }
        }
        //state 92
        for(int i=92, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -19;
            }
        }
        //state 93
        for(int i=93, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -4;
            }
        }
        //state 94
        for(int i=94, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -27;
            }
        }
        //state 95
        for(int i=95, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -28;
            }
        }
        //state 96
        parseTable[96][14]=102;//END
        //state 97
        for(int i=97, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -37;
            }
        }
        parseTable[97][34]=76;//+
        parseTable[97][35]=77;//-
        parseTable[97][121]=79;//addop
        //state 98
        for(int i=98, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -39;
            }
        }
        parseTable[98][36]=80;//*
        parseTable[98][37]=81;///
        parseTable[98][38]=82;//MOD
        parseTable[98][122]=83;//mulop
        //state 99
        for(int i=99, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -41;
            }
        }
        //state 100
        parseTable[100][14]=103;//END
        //state 101
        for(int i=101, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -14;
            }
        }
        //state 102
        parseTable[102][20]=104;//IF
        //state 103
        parseTable[103][23]=105;//LOOP
        //state 104
        for(int i=104, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -31;
            }
        }
        //state 105
        for(int i=105, j=0;j<parseTable[i].length;j++){
            for(int k=0;k<parseTable[i].length;k++){
                parseTable[i][k] = -32;
            }
        }
    }
    
    /**
     * Get the next state given the current state and the parse value of the 
     * next token
     * @param s the current state
     * @param t the parse value of the next token
     * @return the state to change to
     */
    public int getNextState(int s, int t){
        return parseTable[s][t];
    }
}