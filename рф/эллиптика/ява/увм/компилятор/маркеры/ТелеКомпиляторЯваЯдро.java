/*
 * Авторские права ↄ⃝ 2015, Антон Астафьев Ѱ҃
 *
 * Этот код — свободное программное обеспечение. Вы можете распространять и/или изменять его
 * при условии соблюдения положений Универсальной общественной лицензии GNU только 2-й версии, как
 * опубликовано Фондом Свободных Программ.
 *
 * Этот код распространяется с надеждой на то, что он будет полезен,
 * но БЕЗ КАКИХ-ЛИБО ГАРАНТИЙ, даже без подразумеваемой гарантии КОММЕРЧЕСКОЙ ЦЕННОСТИ или
 * СООТВЕТСТВИЯ КОНКРЕТНОМУ ПРЕДНАЗНАЧЕНИЮ. Смотрите текст Универсальной общественной лицензии GNU
 * 2-й версии для подробного объяснения (копия включена в файл ЛИЦЕНЗИЯ, поставляемый с этим кодом).
 *
 */

package рф.эллиптика.ява.увм.компилятор.маркеры;

import java.rmi.RemoteException;
import java.util.Queue;

import javax.annotation.processing.Processor;
import javax.tools.JavaFileObject;

import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symbol.ClassSymbol;
import com.sun.tools.javac.code.Symbol.CompletionFailure;
import com.sun.tools.javac.comp.AttrContext;
import com.sun.tools.javac.comp.Env;
import com.sun.tools.javac.main.JavaCompiler;
import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Pair;

/**
 * Тип <code>ТелеКомпиляторЯваЯдро</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ТелеКомпиляторЯваЯдро extends СопряжениеТелеМаркер {

	int errorCount() throws RemoteException;

	int warningCount() throws RemoteException;

	CharSequence readSource(JavaFileObject filename) throws RemoteException;

	JCCompilationUnit parse(Строка filename) throws RemoteException;

	JCCompilationUnit parse(JavaFileObject filename) throws RemoteException;

	Symbol resolveBinaryNameOrIdent(Строка name) throws RemoteException;

	Symbol resolveIdent(Строка name) throws RemoteException;

	void complete(ClassSymbol c) throws CompletionFailure, RemoteException;

	void compile(List<JavaFileObject> sourceFileObject) throws Throwable;

	void compile(List<JavaFileObject> sourceFileObjects, List<Строка> classnames, Iterable<? extends Processor> processors) throws RemoteException;

	List<JCCompilationUnit> parseFiles(Iterable<JavaFileObject> fileObjects) throws RemoteException;

	List<JCCompilationUnit> enterTreesIfNeeded(List<JCCompilationUnit> roots) throws RemoteException;

	List<JCCompilationUnit> enterTrees(List<JCCompilationUnit> roots) throws RemoteException;

	void initProcessAnnotations(Iterable<? extends Processor> processors) throws RemoteException;

	JavaCompiler processAnnotations(List<JCCompilationUnit> roots) throws RemoteException;

	JavaCompiler processAnnotations(List<JCCompilationUnit> roots, List<Строка> classnames) throws RemoteException;

	Queue<Env<AttrContext>> attribute(Queue<Env<AttrContext>> envs) throws RemoteException;

	Env<AttrContext> attribute(Env<AttrContext> env) throws RemoteException;

	void reportPublicApi(ClassSymbol sym) throws RemoteException;

	Queue<Env<AttrContext>> flow(Queue<Env<AttrContext>> envs) throws RemoteException;

	Queue<Env<AttrContext>> flow(Env<AttrContext> env) throws RemoteException;

	Queue<Pair<Env<AttrContext>, JCClassDecl>> desugar(Queue<Env<AttrContext>> envs) throws RemoteException;

	void generate(Queue<Pair<Env<AttrContext>, JCClassDecl>> queue) throws RemoteException;

	void generate(Queue<Pair<Env<AttrContext>, JCClassDecl>> queue, Queue<JavaFileObject> results) throws RemoteException;

	void reportDeferredDiagnostics() throws RemoteException;

	void close() throws RemoteException;

	void close(boolean disposeNames) throws RemoteException;

	void printCount(Строка kind, int count) throws RemoteException;

	void initRound(JavaCompiler prev) throws RemoteException;

}
