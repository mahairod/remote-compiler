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

/**
 * 
 */
package рф.эллиптика.ява.увм.компилятор.вопл;

import java.rmi.RemoteException;
import java.util.Queue;

import javax.annotation.processing.Processor;
import javax.tools.JavaFileObject;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеКомпиляторЯваЯдро;

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
 * Тип <code>ТелеКомпиляторЯваЯдроВопл</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
class ТелеКомпиляторЯваЯдроВопл extends ТелеВоплощение<JavaCompiler> implements ТелеКомпиляторЯваЯдро {
	private final JavaCompiler ядро;

	ТелеКомпиляторЯваЯдроВопл(JavaCompiler ядро) throws RemoteException {
		super(ядро);
		this.ядро = ядро;
	}

	@Подмени
	public int errorCount() {
		return ядро.errorCount();
	}

	@Подмени
	public int warningCount() {
		return ядро.warningCount();
	}

	@Подмени
	public CharSequence readSource(JavaFileObject filename) {
		return ядро.readSource(filename);
	}

	@Подмени
	public JCCompilationUnit parse(Строка filename) {
		return ядро.parse(filename);
	}

	@Подмени
	public JCCompilationUnit parse(JavaFileObject filename) {
		return ядро.parse(filename);
	}

	@Подмени
	public Symbol resolveBinaryNameOrIdent(Строка name) {
		return ядро.resolveBinaryNameOrIdent(name);
	}

	@Подмени
	public Symbol resolveIdent(Строка name) {
		return ядро.resolveIdent(name);
	}

	@Подмени
	public void complete(ClassSymbol c) throws CompletionFailure {
		ядро.complete(c);
	}

	@Подмени
	public void compile(List<JavaFileObject> sourceFileObject) throws Throwable {
		ядро.compile(sourceFileObject);
	}

	@Подмени
	public void compile(List<JavaFileObject> sourceFileObjects, List<Строка> classnames,
			Iterable<? extends Processor> processors) {
		ядро.compile(sourceFileObjects, classnames, processors);
	}

	@Подмени
	public List<JCCompilationUnit> parseFiles(Iterable<JavaFileObject> fileObjects) {
		return ядро.parseFiles(fileObjects);
	}

	@Подмени
	public List<JCCompilationUnit> enterTreesIfNeeded(List<JCCompilationUnit> roots) {
		return ядро.enterTreesIfNeeded(roots);
	}

	@Подмени
	public List<JCCompilationUnit> enterTrees(List<JCCompilationUnit> roots) {
		return ядро.enterTrees(roots);
	}

	@Подмени
	public void initProcessAnnotations(Iterable<? extends Processor> processors) {
		ядро.initProcessAnnotations(processors);
	}

	@Подмени
	public JavaCompiler processAnnotations(List<JCCompilationUnit> roots) {
		return ядро.processAnnotations(roots);
	}

	@Подмени
	public JavaCompiler processAnnotations(List<JCCompilationUnit> roots, List<Строка> classnames) {
		return ядро.processAnnotations(roots, classnames);
	}

	@Подмени
	public Queue<Env<AttrContext>> attribute(Queue<Env<AttrContext>> envs) {
		return ядро.attribute(envs);
	}

	@Подмени
	public Env<AttrContext> attribute(Env<AttrContext> env) {
		return ядро.attribute(env);
	}

	@Подмени
	public void reportPublicApi(ClassSymbol sym) {
		ядро.reportPublicApi(sym);
	}

	@Подмени
	public Queue<Env<AttrContext>> flow(Queue<Env<AttrContext>> envs) {
		return ядро.flow(envs);
	}

	@Подмени
	public Queue<Env<AttrContext>> flow(Env<AttrContext> env) {
		return ядро.flow(env);
	}

	@Подмени
	public Queue<Pair<Env<AttrContext>, JCClassDecl>> desugar(Queue<Env<AttrContext>> envs) {
		return ядро.desugar(envs);
	}

	@Подмени
	public void generate(Queue<Pair<Env<AttrContext>, JCClassDecl>> queue) {
		ядро.generate(queue);
	}

	@Подмени
	public void generate(Queue<Pair<Env<AttrContext>, JCClassDecl>> queue, Queue<JavaFileObject> results) {
		ядро.generate(queue, results);
	}

	@Подмени
	public void reportDeferredDiagnostics() {
		ядро.reportDeferredDiagnostics();
	}

	@Подмени
	public void close() {
		ядро.close();
	}

	@Подмени
	public void close(boolean disposeNames) {
		ядро.close(disposeNames);
	}

	@Подмени
	public void printCount(Строка kind, int count) {
		ядро.printCount(kind, count);
	}

	@Подмени
	public void initRound(JavaCompiler prev) {
		ядро.initRound(prev);
	}

}
