
/* A Bison parser, made by GNU Bison 2.4.1.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java
   
      Copyright (C) 2007, 2008 Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* First part of user declarations.  */


/**
 * A Bison parser, automatically generated from <tt>grammar.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
class YYParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "2.4.1";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";


  /** True if verbose error messages are enabled.  */
  public boolean errorVerbose = false;



  /** Token returned by the scanner to signal the end of its input.  */
  public static final int EOF = 0;

/* Tokens.  */
  /** Token number, to be returned by the scanner.  */
  public static final int EOP = 258;
  /** Token number, to be returned by the scanner.  */
  public static final int DECLARE = 259;
  /** Token number, to be returned by the scanner.  */
  public static final int id = 260;
  /** Token number, to be returned by the scanner.  */
  public static final int smcln = 261;
  /** Token number, to be returned by the scanner.  */
  public static final int assign = 262;
  /** Token number, to be returned by the scanner.  */
  public static final int BOOLEAN = 263;
  /** Token number, to be returned by the scanner.  */
  public static final int CHAR = 264;
  /** Token number, to be returned by the scanner.  */
  public static final int num = 265;
  /** Token number, to be returned by the scanner.  */
  public static final int comma = 266;
  /** Token number, to be returned by the scanner.  */
  public static final int NUMBER = 267;
  /** Token number, to be returned by the scanner.  */
  public static final int INT = 268;
  /** Token number, to be returned by the scanner.  */
  public static final int SMALLINT = 269;
  /** Token number, to be returned by the scanner.  */
  public static final int POSITIVE = 270;
  /** Token number, to be returned by the scanner.  */
  public static final int BEGIN = 271;
  /** Token number, to be returned by the scanner.  */
  public static final int END = 272;
  /** Token number, to be returned by the scanner.  */
  public static final int NULL = 273;
  /** Token number, to be returned by the scanner.  */
  public static final int amp = 277;
  /** Token number, to be returned by the scanner.  */
  public static final int IF = 278;
  /** Token number, to be returned by the scanner.  */
  public static final int THEN = 279;
  /** Token number, to be returned by the scanner.  */
  public static final int WHILE = 280;
  /** Token number, to be returned by the scanner.  */
  public static final int LOOP = 281;
  /** Token number, to be returned by the scanner.  */
  public static final int schar = 282;
  /** Token number, to be returned by the scanner.  */
  public static final int TRUE = 283;
  /** Token number, to be returned by the scanner.  */
  public static final int FALSE = 284;
  /** Token number, to be returned by the scanner.  */
  public static final int NOT = 285;
  /** Token number, to be returned by the scanner.  */
  public static final int GT = 286;
  /** Token number, to be returned by the scanner.  */
  public static final int GTE = 287;
  /** Token number, to be returned by the scanner.  */
  public static final int Eq = 288;
  /** Token number, to be returned by the scanner.  */
  public static final int LTE = 289;
  /** Token number, to be returned by the scanner.  */
  public static final int LT = 290;
  /** Token number, to be returned by the scanner.  */
  public static final int NEq = 291;
  /** Token number, to be returned by the scanner.  */
  public static final int plus = 292;
  /** Token number, to be returned by the scanner.  */
  public static final int minus = 293;
  /** Token number, to be returned by the scanner.  */
  public static final int mult = 294;
  /** Token number, to be returned by the scanner.  */
  public static final int div = 295;
  /** Token number, to be returned by the scanner.  */
  public static final int MOD = 296;
  /** Token number, to be returned by the scanner.  */
  public static final int lparen = 297;
  /** Token number, to be returned by the scanner.  */
  public static final int rparen = 298;



  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>YYParser</tt>.
   */
  public interface Lexer {
    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.  */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token. 
     * @return the token identifier corresponding to the next token. */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param s The string for the error message.  */
     void yyerror (String s);
  }

  /** The object doing lexical analysis for us.  */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public YYParser (Lexer yylexer) {
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  private final int yylex () throws java.io.IOException {
    return yylexer.yylex ();
  }
  protected final void yyerror (String s) {
    yylexer.yyerror (s);
  }

  

  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;
    
    public final void push (int state, Object value    	   	      	    ) {
      height++;
      if (size == height) 
        {
	  int[] newStateStack = new int[size * 2];
	  System.arraycopy (stateStack, 0, newStateStack, 0, height);
	  stateStack = newStateStack;
	  
	  
	  Object[] newValueStack = new Object[size * 2];
	  System.arraycopy (valueStack, 0, newValueStack, 0, height);
	  valueStack = newValueStack;

	  size *= 2;
	}

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      height--;
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
	java.util.Arrays.fill (valueStack, height - num + 1, height, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out)
    {
      out.print ("Stack now");
      
      for (int i = 0; i < height; i++)
        {
	  out.print (' ');
	  out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).  */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).  */
  public static final int YYABORT = 1;

  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.  */
  public static final int YYERROR = 2;

  /**
   * Returned by a Bison action in order to print an error message and start
   * error recovery.  */
  public static final int YYFAIL = 3;

  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;

  private int yyerrstatus_ = 0;

  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.  */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    

    /* If YYLEN is nonzero, implement the default value of the action:
       `$$ = $1'.  Otherwise, use the top of the stack.
    
       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);
    
    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
	

/* Line 353 of lalr1.java  */
/* Line 353 of "grammar.java"  */
	default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    yyn = yyr1_[yyn];
    int yystate = yypgoto_[yyn - yyntokens_] + yystack.stateAt (0);
    if (0 <= yystate && yystate <= yylast_
	&& yycheck_[yystate] == yystack.stateAt (0))
      yystate = yytable_[yystate];
    else
      yystate = yydefgoto_[yyn - yyntokens_];

    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }

  /* Return YYSTR after stripping away unnecessary quotes and
     backslashes, so that it's suitable for yyerror.  The heuristic is
     that double-quoting is unnecessary unless the string contains an
     apostrophe, a comma, or backslash (other than backslash-backslash).
     YYSTR is taken from yytname.  */
  private final String yytnamerr_ (String yystr)
  {
    if (yystr.charAt (0) == '"')
      {
        StringBuffer yyr = new StringBuffer ();
        strip_quotes: for (int i = 1; i < yystr.length (); i++)
          switch (yystr.charAt (i))
            {
            case '\'':
            case ',':
              break strip_quotes;

            case '\\':
	      if (yystr.charAt(++i) != '\\')
                break strip_quotes;
              /* Fall through.  */
            default:
              yyr.append (yystr.charAt (i));
              break;

            case '"':
              return yyr.toString ();
            }
      }
    else if (yystr.equals ("$end"))
      return "end of input";

    return yystr;
  }

  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
			         Object yyvaluep				 )
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
	      + yytname_[yytype] + " ("
	      + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }

  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse () throws java.io.IOException
  {
    /// Lookahead and lookahead in internal form.
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;

    YYStack yystack = new YYStack ();

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /// Semantic value of the lookahead.
    Object yylval = null;

    int yyresult;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;


    /* Initialize the stack.  */
    yystack.push (yystate, yylval);

    int label = YYNEWSTATE;
    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
	   pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);
    
        /* Accept?  */
        if (yystate == yyfinal_)
          return true;
    
        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yyn == yypact_ninf_)
          {
            label = YYDEFAULT;
	    break;
          }
    
        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {
	    yycdebug ("Reading a token: ");
	    yychar = yylex ();
            
            yylval = yylexer.getLVal ();
          }
    
        /* Convert token to internal form.  */
        if (yychar <= EOF)
          {
	    yychar = yytoken = EOF;
	    yycdebug ("Now at end of input.\n");
          }
        else
          {
	    yytoken = yytranslate_ (yychar);
	    yy_symbol_print ("Next token is", yytoken,
	    		     yylval);
          }
    
        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;
    
        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
	    if (yyn == 0 || yyn == yytable_ninf_)
	      label = YYFAIL;
	    else
	      {
	        yyn = -yyn;
	        label = YYREDUCE;
	      }
          }
    
        else
          {
            /* Shift the lookahead token.  */
	    yy_symbol_print ("Shifting", yytoken,
	    		     yylval);
    
            /* Discard the token being shifted.  */
            yychar = yyempty_;
    
            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;
    
            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;
    
      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYFAIL;
        else
          label = YYREDUCE;
        break;
    
      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
	yystate = yystack.stateAt (0);
        break;
    
      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYFAIL:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
	    ++yynerrs_;
	    yyerror (yysyntax_error (yystate, yytoken));
          }
    
        
        if (yyerrstatus_ == 3)
          {
	    /* If just tried and failed to reuse lookahead token after an
	     error, discard it.  */
    
	    if (yychar <= EOF)
	      {
	      /* Return failure if at end of input.  */
	      if (yychar == EOF)
	        return false;
	      }
	    else
	      yychar = yyempty_;
          }
    
        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;
    
      /*---------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `---------------------------------------------------*/
      case YYERROR:
    
        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;
    
      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;	/* Each real token shifted decrements this.  */
    
        for (;;)
          {
	    yyn = yypact_[yystate];
	    if (yyn != yypact_ninf_)
	      {
	        yyn += yyterror_;
	        if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
	          {
	            yyn = yytable_[yyn];
	            if (0 < yyn)
		      break;
	          }
	      }
    
	    /* Pop the current state because it cannot handle the error token.  */
	    if (yystack.height == 1)
	      return false;
    
	    
	    yystack.pop ();
	    yystate = yystack.stateAt (0);
	    if (yydebug > 0)
	      yystack.print (yyDebugStream);
          }
    
	

        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
			 yylval);
    
        yystate = yyn;
	yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;
    
        /* Accept.  */
      case YYACCEPT:
        return true;
    
        /* Abort.  */
      case YYABORT:
        return false;
      }
  }

  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    if (errorVerbose)
      {
        int yyn = yypact_[yystate];
        if (yypact_ninf_ < yyn && yyn <= yylast_)
          {
	    StringBuffer res;

	    /* Start YYX at -YYN if negative to avoid negative indexes in
	       YYCHECK.  */
	    int yyxbegin = yyn < 0 ? -yyn : 0;

	    /* Stay within bounds of both yycheck and yytname.  */
	    int yychecklim = yylast_ - yyn + 1;
	    int yyxend = yychecklim < yyntokens_ ? yychecklim : yyntokens_;
	    int count = 0;
	    for (int x = yyxbegin; x < yyxend; ++x)
	      if (yycheck_[x + yyn] == x && x != yyterror_)
	        ++count;

	    // FIXME: This method of building the message is not compatible
	    // with internationalization.
	    res = new StringBuffer ("syntax error, unexpected ");
	    res.append (yytnamerr_ (yytname_[tok]));
	    if (count < 5)
	      {
	        count = 0;
	        for (int x = yyxbegin; x < yyxend; ++x)
	          if (yycheck_[x + yyn] == x && x != yyterror_)
		    {
		      res.append (count++ == 0 ? ", expecting " : " or ");
		      res.append (yytnamerr_ (yytname_[x]));
		    }
	      }
	    return res.toString ();
          }
      }

    return "syntax error";
  }


  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
  private static final byte yypact_ninf_ = -55;
  private static final byte yypact_[] =
  {
         3,    -3,    13,     5,    58,   -55,   -55,    24,    20,   -55,
     -55,   -18,   -11,    -6,    -4,    34,   -55,   -55,    43,    33,
      14,    26,   -55,    64,     4,     4,   -55,    57,    69,   -55,
     -55,   -55,    66,    66,    66,    66,    -2,    71,    -2,   -55,
      73,    74,   -55,   -55,   -55,   -55,   -55,   -55,     4,    56,
      27,   -35,   -55,    55,    76,    32,    72,    41,    42,    44,
      45,   -55,   -55,   -55,    -3,   -55,    46,    47,   -55,    32,
     -55,   -55,   -55,   -55,   -55,   -55,   -55,   -55,     4,     4,
     -55,   -55,   -55,     4,    32,   -55,   -55,    81,   -55,   -55,
     -55,   -55,   -55,   -55,   -55,   -55,    75,   -20,   -35,   -55,
      77,   -55,    63,    67,   -55,   -55
  };

  /* YYDEFACT[S] -- default rule to reduce with in state S when YYTABLE
     doesn't specify something else to do.  Zero means the default is an
     error.  */
  private static final byte yydefact_[] =
  {
         4,     6,     0,     0,     0,     3,     1,     0,     0,    11,
      12,     0,     0,     0,     0,     8,     9,    10,     0,     0,
       0,     0,    30,     0,     0,     0,    27,     0,    23,    24,
      26,     2,    14,    14,    14,    14,     0,     0,     0,    22,
       0,     0,    31,    43,    44,    47,    45,    46,     0,     0,
      37,    39,    41,     0,     0,     0,    16,     0,     0,     0,
       0,    36,     7,    35,     6,    34,     0,     0,    48,     0,
      49,    50,    51,    52,    53,    54,    55,    56,     0,     0,
      57,    58,    59,     0,     0,    21,    25,     0,    13,    17,
      18,    19,    20,     5,    28,    29,     0,    38,    40,    42,
       0,    15,     0,     0,    32,    33
  };

  /* YYPGOTO[NTERM-NUM].  */
  private static final byte yypgoto_[] =
  {
       -55,   -55,   -55,    31,   -55,   -55,   -55,   -23,   -55,   -55,
      93,   -55,   -55,   -54,   -55,    59,    -5,    21,    19,   -48,
     -55,   -55,   -55
  };

  /* YYDEFGOTO[NTERM-NUM].  */
  private static final byte
  yydefgoto_[] =
  {
        -1,     2,     3,     5,    37,    15,    16,    57,    88,    17,
      26,    27,    28,    29,    30,    62,    63,    50,    51,    52,
      78,    79,    83
  };

  /* YYTABLE[YYPACT[STATE-NUM]].  What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule which
     number is the opposite.  If zero, do what YYDEFACT says.  */
  private static final byte yytable_ninf_ = -1;
  private static final byte
  yytable_[] =
  {
        68,    86,     4,    43,    80,    81,    82,     1,    44,    43,
      58,    59,    60,     6,    44,    96,    45,    76,    77,    49,
      53,     7,    45,    31,    32,    61,    46,    47,    48,    18,
     100,    33,    46,    47,    48,    99,    34,    18,    35,    39,
       7,    36,    19,    20,    21,    22,    23,    24,     7,    25,
      38,    20,    21,    22,    23,    24,    40,    25,    70,    71,
      72,    73,    74,    75,    76,    77,     9,    10,    41,    42,
      11,    12,    13,    14,    54,    55,    56,    64,    66,    67,
      69,    84,    85,    87,    89,    90,   104,    91,    92,    94,
      95,   101,   102,   105,   103,    93,     8,    65,    98,    97
  };

  /* YYCHECK.  */
  private static final byte
  yycheck_[] =
  {
        48,    55,     5,     5,    39,    40,    41,     4,    10,     5,
      33,    34,    35,     0,    10,    69,    18,    37,    38,    24,
      25,    16,    18,     3,    42,    27,    28,    29,    30,     5,
      84,    42,    28,    29,    30,    83,    42,     5,    42,     6,
      16,     7,    18,    19,    20,    21,    22,    23,    16,    25,
       7,    19,    20,    21,    22,    23,    42,    25,    31,    32,
      33,    34,    35,    36,    37,    38,     8,     9,    42,     5,
      12,    13,    14,    15,    17,     6,    10,     6,     5,     5,
      24,    26,     6,    11,    43,    43,    23,    43,    43,    43,
      43,    10,    17,    26,    17,    64,     3,    38,    79,    78
  };

  /* STOS_[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
  private static final byte
  yystos_[] =
  {
         0,     4,    45,    46,     5,    47,     0,    16,    54,     8,
       9,    12,    13,    14,    15,    49,    50,    53,     5,    18,
      19,    20,    21,    22,    23,    25,    54,    55,    56,    57,
      58,     3,    42,    42,    42,    42,     7,    48,     7,     6,
      42,    42,     5,     5,    10,    18,    28,    29,    30,    60,
      61,    62,    63,    60,    17,     6,    10,    51,    51,    51,
      51,    27,    59,    60,     6,    59,     5,     5,    63,    24,
      31,    32,    33,    34,    35,    36,    37,    38,    64,    65,
      39,    40,    41,    66,    26,     6,    57,    11,    52,    43,
      43,    43,    43,    47,    43,    43,    57,    61,    62,    63,
      57,    10,    17,    17,    23,    26
  };

  /* TOKEN_NUMBER_[YYLEX-NUM] -- Internal symbol number corresponding
     to YYLEX-NUM.  */
  private static final short
  yytoken_number_[] =
  {
         0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298
  };

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte
  yyr1_[] =
  {
         0,    44,    45,    46,    46,    47,    47,    48,    48,    49,
      49,    49,    50,    51,    51,    52,    52,    53,    53,    53,
      53,    54,    55,    55,    56,    56,    57,    57,    57,    57,
      57,    57,    57,    57,    58,    59,    59,    60,    60,    61,
      61,    62,    62,    63,    63,    63,    63,    63,    63,    64,
      64,    64,    64,    64,    64,    65,    65,    66,    66,    66
  };

  /* YYR2[YYN] -- Number of symbols composing right hand side of rule YYN.  */
  private static final byte
  yyr2_[] =
  {
         0,     2,     3,     2,     0,     5,     0,     2,     0,     1,
       1,     1,     1,     2,     0,     2,     0,     4,     4,     4,
       4,     4,     2,     1,     1,     3,     1,     1,     4,     4,
       1,     2,     6,     6,     3,     1,     1,     1,     3,     1,
       3,     1,     3,     1,     1,     1,     1,     1,     2,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1
  };

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] =
  {
    "$end", "error", "$undefined", "\"$\"", "DECLARE", "id", "\";\"",
  "\":=\"", "BOOLEAN", "CHAR", "num", "\",\"", "NUMBER", "INT", "SMALLINT",
  "POSITIVE", "BEGIN", "END", "NULL", "DBMS_OUTPUT.PUT_LINE",
  "DBMS_OUTPUT.PUT", "DBMS_OUTPUT.NEW_LINE", "\"&\"", "IF", "THEN",
  "WHILE", "LOOP", "schar", "TRUE", "FALSE", "NOT", "\">\"", "\">=\"",
  "\"=\"", "\"<=\"", "\"<\"", "\"<>\"", "\"+\"", "\"-\"", "\"*\"", "\"/\"",
  "MOD", "\"(\"", "\")\"", "$accept", "block", "declarations",
  "declare_rest", "default", "data_type", "characters", "size",
  "size_option", "numbers", "compound_statement", "optional_statements",
  "statement_list", "statement", "lefthandside", "righthandside",
  "expression", "simple_expression", "term", "factor", "relop", "addop",
  "mulop", null
  };

  /* YYRHS -- A `-1'-separated list of the rules' RHS.  */
  private static final byte yyrhs_[] =
  {
        45,     0,    -1,    46,    54,     3,    -1,     4,    47,    -1,
      -1,     5,    49,    48,     6,    47,    -1,    -1,     7,    59,
      -1,    -1,    50,    -1,    53,    -1,     8,    -1,     9,    -1,
      10,    52,    -1,    -1,    11,    10,    -1,    -1,    12,    42,
      51,    43,    -1,    13,    42,    51,    43,    -1,    14,    42,
      51,    43,    -1,    15,    42,    51,    43,    -1,    16,    55,
      17,     6,    -1,    18,     6,    -1,    56,    -1,    57,    -1,
      56,     6,    57,    -1,    58,    -1,    54,    -1,    19,    42,
       5,    43,    -1,    20,    42,     5,    43,    -1,    21,    -1,
      22,     5,    -1,    23,    60,    24,    57,    17,    23,    -1,
      25,    60,    26,    57,    17,    26,    -1,     5,     7,    59,
      -1,    60,    -1,    27,    -1,    61,    -1,    61,    64,    61,
      -1,    62,    -1,    61,    65,    62,    -1,    63,    -1,    62,
      66,    63,    -1,     5,    -1,    10,    -1,    28,    -1,    29,
      -1,    18,    -1,    30,    63,    -1,    31,    -1,    32,    -1,
      33,    -1,    34,    -1,    35,    -1,    36,    -1,    37,    -1,
      38,    -1,    39,    -1,    40,    -1,    41,    -1
  };

  /* YYPRHS[YYN] -- Index of the first RHS symbol of rule number YYN in
     YYRHS.  */
  private static final short yyprhs_[] =
  {
         0,     0,     3,     7,    10,    11,    17,    18,    21,    22,
      24,    26,    28,    30,    33,    34,    37,    38,    43,    48,
      53,    58,    63,    66,    68,    70,    74,    76,    78,    83,
      88,    90,    93,   100,   107,   111,   113,   115,   117,   121,
     123,   127,   129,   133,   135,   137,   139,   141,   143,   146,
     148,   150,   152,   154,   156,   158,   160,   162,   164,   166
  };

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] =
  {
         0,    57,    57,    59,    60,    62,    63,    65,    66,    68,
      69,    70,    72,    74,    75,    77,    78,    80,    81,    82,
      83,    85,    87,    88,    90,    91,    93,    94,    95,    96,
      97,    98,    99,   100,   102,   104,   105,   107,   108,   110,
     111,   113,   114,   116,   117,   118,   119,   120,   121,   123,
     124,   125,   126,   127,   128,   130,   131,   133,   134,   135
  };

  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
	      + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
		       yyrhs_[yyprhs_[yyrule] + yyi],
		       ((yystack.valueAt (yynrhs-(yyi + 1)))));
  }

  /* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
  private static final byte yytranslate_table_[] =
  {
         0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43
  };

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 99;
  private static final int yynnts_ = 23;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 6;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 44;

  private static final int yyuser_token_number_max_ = 298;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */

}


/* Line 879 of lalr1.java  */
/* Line 137 of "grammar.y"  */


/* Epilogue */
