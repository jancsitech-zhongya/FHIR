/*
 * (C) Copyright IBM Corp. 2021
 *
 * SPDX-License-Identifier: Apache-2.0
 */

// Generated from fhir-path/FHIRPath.g4 by ANTLR 4.9.3
package com.ibm.fhir.path;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FHIRPathLexer extends Lexer {
    static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9,
        T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17,
        T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24,
        T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31,
        T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38,
        T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45,
        T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52,
        T__52=53, T__53=54, DATE=55, DATETIME=56, TIME=57, IDENTIFIER=58, DELIMITEDIDENTIFIER=59,
        STRING=60, NUMBER=61, WS=62, COMMENT=63, LINE_COMMENT=64;
    public static String[] channelNames = {
        "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };

    public static String[] modeNames = {
        "DEFAULT_MODE"
    };

    private static String[] makeRuleNames() {
        return new String[] {
            "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8",
            "T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16",
            "T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24",
            "T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32",
            "T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40",
            "T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48",
            "T__49", "T__50", "T__51", "T__52", "T__53", "DATE", "DATETIME", "TIME",
            "DATEFORMAT", "TIMEFORMAT", "TIMEZONEOFFSETFORMAT", "IDENTIFIER", "DELIMITEDIDENTIFIER",
            "STRING", "NUMBER", "WS", "COMMENT", "LINE_COMMENT", "ESC", "UNICODE",
            "HEX"
        };
    }
    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] {
            null, "'.'", "'['", "']'", "'+'", "'-'", "'*'", "'/'", "'div'", "'mod'",
            "'&'", "'is'", "'as'", "'|'", "'<='", "'<'", "'>'", "'>='", "'='", "'~'",
            "'!='", "'!~'", "'in'", "'contains'", "'and'", "'or'", "'xor'", "'implies'",
            "'('", "')'", "'{'", "'}'", "'true'", "'false'", "'%'", "'$this'", "'$index'",
            "'$total'", "','", "'year'", "'month'", "'week'", "'day'", "'hour'",
            "'minute'", "'second'", "'millisecond'", "'years'", "'months'", "'weeks'",
            "'days'", "'hours'", "'minutes'", "'seconds'", "'milliseconds'"
        };
    }
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static String[] makeSymbolicNames() {
        return new String[] {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, "DATE", "DATETIME", "TIME",
            "IDENTIFIER", "DELIMITEDIDENTIFIER", "STRING", "NUMBER", "WS", "COMMENT",
            "LINE_COMMENT"
        };
    }
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }


    public FHIRPathLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }

    @Override
    public String getGrammarFileName() { return "FHIRPath.g4"; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String getSerializedATN() { return _serializedATN; }

    @Override
    public String[] getChannelNames() { return channelNames; }

    @Override
    public String[] getModeNames() { return modeNames; }

    @Override
    public ATN getATN() { return _ATN; }

    public static final String _serializedATN =
        "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2B\u020d\b\1\4\2\t"+
        "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
        "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
        "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
        "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
        "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
        ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
        "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
        "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\3\2\3\2\3"+
        "\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n"+
        "\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3"+
        "\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3"+
        "\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
        "\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3"+
        "\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3"+
        "!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3"+
        "%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)"+
        "\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3."+
        "\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
        "\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62"+
        "\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65"+
        "\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
        "\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
        "\38\38\38\39\39\39\39\39\59\u0184\n9\59\u0186\n9\3:\3:\3:\3:\3;\3;\3;"+
        "\3;\3;\3;\3;\3;\3;\3;\5;\u0196\n;\5;\u0198\n;\3<\3<\3<\3<\3<\3<\3<\3<"+
        "\3<\3<\6<\u01a4\n<\r<\16<\u01a5\5<\u01a8\n<\5<\u01aa\n<\5<\u01ac\n<\3"+
        "=\3=\3=\3=\3=\3=\3=\5=\u01b5\n=\3>\5>\u01b8\n>\3>\7>\u01bb\n>\f>\16>\u01be"+
        "\13>\3?\3?\3?\7?\u01c3\n?\f?\16?\u01c6\13?\3?\3?\3@\3@\3@\7@\u01cd\n@"+
        "\f@\16@\u01d0\13@\3@\3@\3A\6A\u01d5\nA\rA\16A\u01d6\3A\3A\6A\u01db\nA"+
        "\rA\16A\u01dc\5A\u01df\nA\3B\6B\u01e2\nB\rB\16B\u01e3\3B\3B\3C\3C\3C\3"+
        "C\7C\u01ec\nC\fC\16C\u01ef\13C\3C\3C\3C\3C\3C\3D\3D\3D\3D\7D\u01fa\nD"+
        "\fD\16D\u01fd\13D\3D\3D\3E\3E\3E\5E\u0204\nE\3F\3F\3F\3F\3F\3F\3G\3G\5"+
        "\u01c4\u01ce\u01ed\2H\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
        "\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
        "\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63"+
        "e\64g\65i\66k\67m8o9q:s;u\2w\2y\2{<}=\177>\u0081?\u0083@\u0085A\u0087"+
        "B\u0089\2\u008b\2\u008d\2\3\2\n\3\2\62;\4\2--//\5\2C\\aac|\6\2\62;C\\"+
        "aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\n\2))\61\61^^bbhhppttvv\5\2\62;"+
        "CHch\2\u021b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
        "\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
        "\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
        "\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
        "\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
        "\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
        "\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
        "S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3"+
        "\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2"+
        "\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2"+
        "\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3"+
        "\2\2\2\3\u008f\3\2\2\2\5\u0091\3\2\2\2\7\u0093\3\2\2\2\t\u0095\3\2\2\2"+
        "\13\u0097\3\2\2\2\r\u0099\3\2\2\2\17\u009b\3\2\2\2\21\u009d\3\2\2\2\23"+
        "\u00a1\3\2\2\2\25\u00a5\3\2\2\2\27\u00a7\3\2\2\2\31\u00aa\3\2\2\2\33\u00ad"+
        "\3\2\2\2\35\u00af\3\2\2\2\37\u00b2\3\2\2\2!\u00b4\3\2\2\2#\u00b6\3\2\2"+
        "\2%\u00b9\3\2\2\2\'\u00bb\3\2\2\2)\u00bd\3\2\2\2+\u00c0\3\2\2\2-\u00c3"+
        "\3\2\2\2/\u00c6\3\2\2\2\61\u00cf\3\2\2\2\63\u00d3\3\2\2\2\65\u00d6\3\2"+
        "\2\2\67\u00da\3\2\2\29\u00e2\3\2\2\2;\u00e4\3\2\2\2=\u00e6\3\2\2\2?\u00e8"+
        "\3\2\2\2A\u00ea\3\2\2\2C\u00ef\3\2\2\2E\u00f5\3\2\2\2G\u00f7\3\2\2\2I"+
        "\u00fd\3\2\2\2K\u0104\3\2\2\2M\u010b\3\2\2\2O\u010d\3\2\2\2Q\u0112\3\2"+
        "\2\2S\u0118\3\2\2\2U\u011d\3\2\2\2W\u0121\3\2\2\2Y\u0126\3\2\2\2[\u012d"+
        "\3\2\2\2]\u0134\3\2\2\2_\u0140\3\2\2\2a\u0146\3\2\2\2c\u014d\3\2\2\2e"+
        "\u0153\3\2\2\2g\u0158\3\2\2\2i\u015e\3\2\2\2k\u0166\3\2\2\2m\u016e\3\2"+
        "\2\2o\u017b\3\2\2\2q\u017e\3\2\2\2s\u0187\3\2\2\2u\u018b\3\2\2\2w\u0199"+
        "\3\2\2\2y\u01b4\3\2\2\2{\u01b7\3\2\2\2}\u01bf\3\2\2\2\177\u01c9\3\2\2"+
        "\2\u0081\u01d4\3\2\2\2\u0083\u01e1\3\2\2\2\u0085\u01e7\3\2\2\2\u0087\u01f5"+
        "\3\2\2\2\u0089\u0200\3\2\2\2\u008b\u0205\3\2\2\2\u008d\u020b\3\2\2\2\u008f"+
        "\u0090\7\60\2\2\u0090\4\3\2\2\2\u0091\u0092\7]\2\2\u0092\6\3\2\2\2\u0093"+
        "\u0094\7_\2\2\u0094\b\3\2\2\2\u0095\u0096\7-\2\2\u0096\n\3\2\2\2\u0097"+
        "\u0098\7/\2\2\u0098\f\3\2\2\2\u0099\u009a\7,\2\2\u009a\16\3\2\2\2\u009b"+
        "\u009c\7\61\2\2\u009c\20\3\2\2\2\u009d\u009e\7f\2\2\u009e\u009f\7k\2\2"+
        "\u009f\u00a0\7x\2\2\u00a0\22\3\2\2\2\u00a1\u00a2\7o\2\2\u00a2\u00a3\7"+
        "q\2\2\u00a3\u00a4\7f\2\2\u00a4\24\3\2\2\2\u00a5\u00a6\7(\2\2\u00a6\26"+
        "\3\2\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7u\2\2\u00a9\30\3\2\2\2\u00aa"+
        "\u00ab\7c\2\2\u00ab\u00ac\7u\2\2\u00ac\32\3\2\2\2\u00ad\u00ae\7~\2\2\u00ae"+
        "\34\3\2\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1\7?\2\2\u00b1\36\3\2\2\2\u00b2"+
        "\u00b3\7>\2\2\u00b3 \3\2\2\2\u00b4\u00b5\7@\2\2\u00b5\"\3\2\2\2\u00b6"+
        "\u00b7\7@\2\2\u00b7\u00b8\7?\2\2\u00b8$\3\2\2\2\u00b9\u00ba\7?\2\2\u00ba"+
        "&\3\2\2\2\u00bb\u00bc\7\u0080\2\2\u00bc(\3\2\2\2\u00bd\u00be\7#\2\2\u00be"+
        "\u00bf\7?\2\2\u00bf*\3\2\2\2\u00c0\u00c1\7#\2\2\u00c1\u00c2\7\u0080\2"+
        "\2\u00c2,\3\2\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7p\2\2\u00c5.\3\2\2\2"+
        "\u00c6\u00c7\7e\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7p\2\2\u00c9\u00ca"+
        "\7v\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7p\2\2\u00cd"+
        "\u00ce\7u\2\2\u00ce\60\3\2\2\2\u00cf\u00d0\7c\2\2\u00d0\u00d1\7p\2\2\u00d1"+
        "\u00d2\7f\2\2\u00d2\62\3\2\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7t\2\2\u00d5"+
        "\64\3\2\2\2\u00d6\u00d7\7z\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7t\2\2\u00d9"+
        "\66\3\2\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7o\2\2\u00dc\u00dd\7r\2\2\u00dd"+
        "\u00de\7n\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7u\2\2"+
        "\u00e18\3\2\2\2\u00e2\u00e3\7*\2\2\u00e3:\3\2\2\2\u00e4\u00e5\7+\2\2\u00e5"+
        "<\3\2\2\2\u00e6\u00e7\7}\2\2\u00e7>\3\2\2\2\u00e8\u00e9\7\177\2\2\u00e9"+
        "@\3\2\2\2\u00ea\u00eb\7v\2\2\u00eb\u00ec\7t\2\2\u00ec\u00ed\7w\2\2\u00ed"+
        "\u00ee\7g\2\2\u00eeB\3\2\2\2\u00ef\u00f0\7h\2\2\u00f0\u00f1\7c\2\2\u00f1"+
        "\u00f2\7n\2\2\u00f2\u00f3\7u\2\2\u00f3\u00f4\7g\2\2\u00f4D\3\2\2\2\u00f5"+
        "\u00f6\7\'\2\2\u00f6F\3\2\2\2\u00f7\u00f8\7&\2\2\u00f8\u00f9\7v\2\2\u00f9"+
        "\u00fa\7j\2\2\u00fa\u00fb\7k\2\2\u00fb\u00fc\7u\2\2\u00fcH\3\2\2\2\u00fd"+
        "\u00fe\7&\2\2\u00fe\u00ff\7k\2\2\u00ff\u0100\7p\2\2\u0100\u0101\7f\2\2"+
        "\u0101\u0102\7g\2\2\u0102\u0103\7z\2\2\u0103J\3\2\2\2\u0104\u0105\7&\2"+
        "\2\u0105\u0106\7v\2\2\u0106\u0107\7q\2\2\u0107\u0108\7v\2\2\u0108\u0109"+
        "\7c\2\2\u0109\u010a\7n\2\2\u010aL\3\2\2\2\u010b\u010c\7.\2\2\u010cN\3"+
        "\2\2\2\u010d\u010e\7{\2\2\u010e\u010f\7g\2\2\u010f\u0110\7c\2\2\u0110"+
        "\u0111\7t\2\2\u0111P\3\2\2\2\u0112\u0113\7o\2\2\u0113\u0114\7q\2\2\u0114"+
        "\u0115\7p\2\2\u0115\u0116\7v\2\2\u0116\u0117\7j\2\2\u0117R\3\2\2\2\u0118"+
        "\u0119\7y\2\2\u0119\u011a\7g\2\2\u011a\u011b\7g\2\2\u011b\u011c\7m\2\2"+
        "\u011cT\3\2\2\2\u011d\u011e\7f\2\2\u011e\u011f\7c\2\2\u011f\u0120\7{\2"+
        "\2\u0120V\3\2\2\2\u0121\u0122\7j\2\2\u0122\u0123\7q\2\2\u0123\u0124\7"+
        "w\2\2\u0124\u0125\7t\2\2\u0125X\3\2\2\2\u0126\u0127\7o\2\2\u0127\u0128"+
        "\7k\2\2\u0128\u0129\7p\2\2\u0129\u012a\7w\2\2\u012a\u012b\7v\2\2\u012b"+
        "\u012c\7g\2\2\u012cZ\3\2\2\2\u012d\u012e\7u\2\2\u012e\u012f\7g\2\2\u012f"+
        "\u0130\7e\2\2\u0130\u0131\7q\2\2\u0131\u0132\7p\2\2\u0132\u0133\7f\2\2"+
        "\u0133\\\3\2\2\2\u0134\u0135\7o\2\2\u0135\u0136\7k\2\2\u0136\u0137\7n"+
        "\2\2\u0137\u0138\7n\2\2\u0138\u0139\7k\2\2\u0139\u013a\7u\2\2\u013a\u013b"+
        "\7g\2\2\u013b\u013c\7e\2\2\u013c\u013d\7q\2\2\u013d\u013e\7p\2\2\u013e"+
        "\u013f\7f\2\2\u013f^\3\2\2\2\u0140\u0141\7{\2\2\u0141\u0142\7g\2\2\u0142"+
        "\u0143\7c\2\2\u0143\u0144\7t\2\2\u0144\u0145\7u\2\2\u0145`\3\2\2\2\u0146"+
        "\u0147\7o\2\2\u0147\u0148\7q\2\2\u0148\u0149\7p\2\2\u0149\u014a\7v\2\2"+
        "\u014a\u014b\7j\2\2\u014b\u014c\7u\2\2\u014cb\3\2\2\2\u014d\u014e\7y\2"+
        "\2\u014e\u014f\7g\2\2\u014f\u0150\7g\2\2\u0150\u0151\7m\2\2\u0151\u0152"+
        "\7u\2\2\u0152d\3\2\2\2\u0153\u0154\7f\2\2\u0154\u0155\7c\2\2\u0155\u0156"+
        "\7{\2\2\u0156\u0157\7u\2\2\u0157f\3\2\2\2\u0158\u0159\7j\2\2\u0159\u015a"+
        "\7q\2\2\u015a\u015b\7w\2\2\u015b\u015c\7t\2\2\u015c\u015d\7u\2\2\u015d"+
        "h\3\2\2\2\u015e\u015f\7o\2\2\u015f\u0160\7k\2\2\u0160\u0161\7p\2\2\u0161"+
        "\u0162\7w\2\2\u0162\u0163\7v\2\2\u0163\u0164\7g\2\2\u0164\u0165\7u\2\2"+
        "\u0165j\3\2\2\2\u0166\u0167\7u\2\2\u0167\u0168\7g\2\2\u0168\u0169\7e\2"+
        "\2\u0169\u016a\7q\2\2\u016a\u016b\7p\2\2\u016b\u016c\7f\2\2\u016c\u016d"+
        "\7u\2\2\u016dl\3\2\2\2\u016e\u016f\7o\2\2\u016f\u0170\7k\2\2\u0170\u0171"+
        "\7n\2\2\u0171\u0172\7n\2\2\u0172\u0173\7k\2\2\u0173\u0174\7u\2\2\u0174"+
        "\u0175\7g\2\2\u0175\u0176\7e\2\2\u0176\u0177\7q\2\2\u0177\u0178\7p\2\2"+
        "\u0178\u0179\7f\2\2\u0179\u017a\7u\2\2\u017an\3\2\2\2\u017b\u017c\7B\2"+
        "\2\u017c\u017d\5u;\2\u017dp\3\2\2\2\u017e\u017f\7B\2\2\u017f\u0180\5u"+
        ";\2\u0180\u0185\7V\2\2\u0181\u0183\5w<\2\u0182\u0184\5y=\2\u0183\u0182"+
        "\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0181\3\2\2\2\u0185"+
        "\u0186\3\2\2\2\u0186r\3\2\2\2\u0187\u0188\7B\2\2\u0188\u0189\7V\2\2\u0189"+
        "\u018a\5w<\2\u018at\3\2\2\2\u018b\u018c\t\2\2\2\u018c\u018d\t\2\2\2\u018d"+
        "\u018e\t\2\2\2\u018e\u0197\t\2\2\2\u018f\u0190\7/\2\2\u0190\u0191\t\2"+
        "\2\2\u0191\u0195\t\2\2\2\u0192\u0193\7/\2\2\u0193\u0194\t\2\2\2\u0194"+
        "\u0196\t\2\2\2\u0195\u0192\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0198\3\2"+
        "\2\2\u0197\u018f\3\2\2\2\u0197\u0198\3\2\2\2\u0198v\3\2\2\2\u0199\u019a"+
        "\t\2\2\2\u019a\u01ab\t\2\2\2\u019b\u019c\7<\2\2\u019c\u019d\t\2\2\2\u019d"+
        "\u01a9\t\2\2\2\u019e\u019f\7<\2\2\u019f\u01a0\t\2\2\2\u01a0\u01a7\t\2"+
        "\2\2\u01a1\u01a3\7\60\2\2\u01a2\u01a4\t\2\2\2\u01a3\u01a2\3\2\2\2\u01a4"+
        "\u01a5\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a8\3\2"+
        "\2\2\u01a7\u01a1\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\u01aa\3\2\2\2\u01a9"+
        "\u019e\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ac\3\2\2\2\u01ab\u019b\3\2"+
        "\2\2\u01ab\u01ac\3\2\2\2\u01acx\3\2\2\2\u01ad\u01b5\7\\\2\2\u01ae\u01af"+
        "\t\3\2\2\u01af\u01b0\t\2\2\2\u01b0\u01b1\t\2\2\2\u01b1\u01b2\7<\2\2\u01b2"+
        "\u01b3\t\2\2\2\u01b3\u01b5\t\2\2\2\u01b4\u01ad\3\2\2\2\u01b4\u01ae\3\2"+
        "\2\2\u01b5z\3\2\2\2\u01b6\u01b8\t\4\2\2\u01b7\u01b6\3\2\2\2\u01b8\u01bc"+
        "\3\2\2\2\u01b9\u01bb\t\5\2\2\u01ba\u01b9\3\2\2\2\u01bb\u01be\3\2\2\2\u01bc"+
        "\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd|\3\2\2\2\u01be\u01bc\3\2\2\2"+
        "\u01bf\u01c4\7b\2\2\u01c0\u01c3\5\u0089E\2\u01c1\u01c3\13\2\2\2\u01c2"+
        "\u01c0\3\2\2\2\u01c2\u01c1\3\2\2\2\u01c3\u01c6\3\2\2\2\u01c4\u01c5\3\2"+
        "\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c7\3\2\2\2\u01c6\u01c4\3\2\2\2\u01c7"+
        "\u01c8\7b\2\2\u01c8~\3\2\2\2\u01c9\u01ce\7)\2\2\u01ca\u01cd\5\u0089E\2"+
        "\u01cb\u01cd\13\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cb\3\2\2\2\u01cd\u01d0"+
        "\3\2\2\2\u01ce\u01cf\3\2\2\2\u01ce\u01cc\3\2\2\2\u01cf\u01d1\3\2\2\2\u01d0"+
        "\u01ce\3\2\2\2\u01d1\u01d2\7)\2\2\u01d2\u0080\3\2\2\2\u01d3\u01d5\t\2"+
        "\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01d6\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d6"+
        "\u01d7\3\2\2\2\u01d7\u01de\3\2\2\2\u01d8\u01da\7\60\2\2\u01d9\u01db\t"+
        "\2\2\2\u01da\u01d9\3\2\2\2\u01db\u01dc\3\2\2\2\u01dc\u01da\3\2\2\2\u01dc"+
        "\u01dd\3\2\2\2\u01dd\u01df\3\2\2\2\u01de\u01d8\3\2\2\2\u01de\u01df\3\2"+
        "\2\2\u01df\u0082\3\2\2\2\u01e0\u01e2\t\6\2\2\u01e1\u01e0\3\2\2\2\u01e2"+
        "\u01e3\3\2\2\2\u01e3\u01e1\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u01e5\3\2"+
        "\2\2\u01e5\u01e6\bB\2\2\u01e6\u0084\3\2\2\2\u01e7\u01e8\7\61\2\2\u01e8"+
        "\u01e9\7,\2\2\u01e9\u01ed\3\2\2\2\u01ea\u01ec\13\2\2\2\u01eb\u01ea\3\2"+
        "\2\2\u01ec\u01ef\3\2\2\2\u01ed\u01ee\3\2\2\2\u01ed\u01eb\3\2\2\2\u01ee"+
        "\u01f0\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f1\7,\2\2\u01f1\u01f2\7\61"+
        "\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f4\bC\2\2\u01f4\u0086\3\2\2\2\u01f5"+
        "\u01f6\7\61\2\2\u01f6\u01f7\7\61\2\2\u01f7\u01fb\3\2\2\2\u01f8\u01fa\n"+
        "\7\2\2\u01f9\u01f8\3\2\2\2\u01fa\u01fd\3\2\2\2\u01fb\u01f9\3\2\2\2\u01fb"+
        "\u01fc\3\2\2\2\u01fc\u01fe\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fe\u01ff\bD"+
        "\2\2\u01ff\u0088\3\2\2\2\u0200\u0203\7^\2\2\u0201\u0204\t\b\2\2\u0202"+
        "\u0204\5\u008bF\2\u0203\u0201\3\2\2\2\u0203\u0202\3\2\2\2\u0204\u008a"+
        "\3\2\2\2\u0205\u0206\7w\2\2\u0206\u0207\5\u008dG\2\u0207\u0208\5\u008d"+
        "G\2\u0208\u0209\5\u008dG\2\u0209\u020a\5\u008dG\2\u020a\u008c\3\2\2\2"+
        "\u020b\u020c\t\t\2\2\u020c\u008e\3\2\2\2\32\2\u0183\u0185\u0195\u0197"+
        "\u01a5\u01a7\u01a9\u01ab\u01b4\u01b7\u01ba\u01bc\u01c2\u01c4\u01cc\u01ce"+
        "\u01d6\u01dc\u01de\u01e3\u01ed\u01fb\u0203\3\2\3\2";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}