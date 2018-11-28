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

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Locale;
import java.util.Список;

import javax.annotation.processing.Processor;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.TaskListener;
import com.sun.tools.javac.api.JavacScope;
import com.sun.tools.javac.api.JavacTaskImpl;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.comp.AttrContext;
import com.sun.tools.javac.comp.Env;
import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.model.JavacTypes;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCBlock;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCStatement;
import com.sun.tools.javac.util.Context;

import рф.эллиптика.ява.увм.КонстПарсера;
import рф.эллиптика.ява.увм.СопряжениеЗадачаЯвак;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеЗадачаЯвак;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеОкружение;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеСлушательЗадачи;
import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеОбъектЯваФайла;

/**
 * Тип <code>ТелеЗадачаЯвакВопл</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class ТелеЗадачаЯвакВопл extends ТелеВоплощение<JavacTaskImpl> implements ТелеЗадачаЯвак, СопряжениеЗадачаЯвак {
	private final JavacTaskImpl ядро;

	public ТелеЗадачаЯвакВопл(JavacTaskImpl задачаЯвак) throws RemoteException {
		super(задачаЯвак);
		this.ядро = задачаЯвак;
	}

	public Iterable<? extends CompilationUnitTree> parse() throws IOException {
		return ди.телеФункция(ядро::parse);
	}

	public Iterable<? extends Element> analyze() throws IOException {
		return ди.телеФункция(ядро::analyze);
	}

	public Iterable<? extends JavaFileObject> generate() throws IOException {
		return ди.телеФункция(ядро::generate);
	}

	public void setTaskListener(ТелеСлушательЗадачи tl) {
		ди.телеВызов(ядро::setTaskListener, приведи(tl));
	}

	@Подмени
	public void setTaskListener(TaskListener tl) {
		ди.телеВызов(ядро::setTaskListener, tl);
	}

	public void addTaskListener(ТелеСлушательЗадачи tl) {
		ди.телеВызов(ядро::addTaskListener, приведи(tl));
	}

	@Подмени
	public void addTaskListener(TaskListener tl) {
		ди.телеВызов(ядро::addTaskListener, (TaskListener) tl);
	}

	public void removeTaskListener(ТелеСлушательЗадачи tl) {
		ди.телеВызов(ядро::removeTaskListener, приведи(tl));
	}

	@Подмени
	public void removeTaskListener(TaskListener tl) {
		ди.телеВызов(ядро::removeTaskListener, (TaskListener) tl);
	}

	public TypeMirror getTypeMirror(Iterable<? extends Tree> деревья) {
		return ди.телеФункция(ядро::getTypeMirror, деревья);
	}

	public JavacElements getElements() {
		return ди.телеФункция(ядро::getElements);
	}

	public JavacTypes getTypes() {
		return ди.телеФункция(ядро::getTypes);
	}

	public ТелеОкружение getContextTele() {
		return (ТелеОкружение) ди.телеФункция(ядро::getContext);
	}

	public Context getContext() {
		return ди.телеФункция(ядро::getContext);
	}

	public void updateContext(Context новоеОкружение) {
		ди.телеВызов(ядро::updateContext, новоеОкружение);
	}

	public Iterable<? extends CompilationUnitTree> parse(ТелеОбъектЯваФайла... файлы) throws IOException {
		return ди.телеФункция(ядро::parse, this.<JavaFileObject[]>приведи(файлы));
	}

	public Iterable<? extends CompilationUnitTree> parse(JavaFileObject... файлы) throws IOException {
		return parse( (ТелеОбъектЯваФайла[]) файлы);
	}

	public Iterable<? extends Element> analyze(Iterable<? extends TypeElement> классы) throws IOException {
		return ди.телеФункция(ядро::analyze, классы);
	}

	public Iterable<? extends JavaFileObject> generate(Iterable<? extends TypeElement> классы) throws IOException {
		return ди.телеФункция(ядро::generate, классы);
	}

	public Iterable<? extends TypeElement> enter() throws IOException {
		return ди.телеФункция(ядро::enter);
	}

	public Iterable<? extends TypeElement> enter(Iterable<? extends CompilationUnitTree> деревья) throws IOException {
		return ди.телеФункция(ядро::enter, деревья);
	}

	public Iterable<? extends TypeElement> enterTrees(Iterable<? extends CompilationUnitTree> деревья) throws IOException {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::enterTrees, деревья);
	}

	public Iterable<? extends Processor> getProcessors() {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::getProcessors);
	}

	public JCStatement parseStatement(CharSequence высказ, SourcePositions[] поз) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseStatement, высказ, поз);
	}

	public JCStatement parseStatement(CharSequence высказ, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseStatement, высказ, поз, ошибки);
	}

	public JCExpression parseExpression(CharSequence выраж, SourcePositions[] поз) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseExpression, выраж, поз);
	}

	public JCExpression parseExpression(CharSequence выраж, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseExpression, выраж, поз, ошибки);
	}

	public JCExpression parseVariableInitializer(CharSequence init, SourcePositions[] поз) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseVariableInitializer, init, поз);
	}

	public JCExpression parseVariableInitializer(CharSequence init, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseVariableInitializer, init, поз, ошибки);
	}

	public JCBlock parseStaticBlock(CharSequence блок, SourcePositions[] поз) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseStaticBlock, блок, поз);
	}

	public JCBlock parseStaticBlock(CharSequence блок, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseStaticBlock, блок, поз, ошибки);
	}

	public Tree parseType(Строка выраж) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseType, выраж);
	}

	public Type parseType(Строка выраж, TypeElement сфера) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::parseType, выраж, сфера);
	}

	public Type attributeTree(JCTree дерево, Env<AttrContext> среда) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::attributeTree, дерево, среда);
	}

	public JavacScope attributeTreeTo(JCTree дерево, Env<AttrContext> среда, JCTree до) {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::attributeTreeTo, дерево, среда, до);
	}

	public Список<Env<AttrContext>> getTodo() {
		throw отклНеподдержОперация;
//		return ди.телеФункция(ядро::getTodo);
	}

	public void setProcessors(Iterable<? extends Processor> processors) {
		ди.телеВызов(ядро::setProcessors, processors);
	}

	public void setLocale(Locale locale) {
		ди.телеВызов(ядро::setLocale, locale);
	}

	public Boolean call() {
		return ди.телеФункция(ядро::call);
	}

	private static final UnsupportedOperationException отклНеподдержОперация = new UnsupportedOperationException(КонстПарсера.Строка_Опер_не_поддерж);

}
