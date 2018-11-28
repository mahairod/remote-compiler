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

import com.sun.source.tree.CompilationUnitTree;
import com.sun.source.tree.Tree;
import com.sun.source.util.SourcePositions;
import com.sun.source.util.TaskListener;
import com.sun.tools.javac.api.JavacScope;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.comp.AttrContext;
import com.sun.tools.javac.comp.Env;
import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.model.JavacTypes;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;

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

/**
 *
 * @author Антон Астафьев
 */
public interface ТелеЗадачаЯвак extends СопряжениеТелеМаркер {
	void setProcessors(Iterable<? extends Processor> itrbl) throws RemoteException;
	void setLocale(Locale locale) throws RemoteException;
	Boolean call() throws RemoteException;
	Iterable<? extends CompilationUnitTree> parse(ТелеОбъектЯваФайла... файлы) throws IOException;
	Iterable<? extends Element> analyze(Iterable<? extends TypeElement> классы) throws IOException;
	Iterable<? extends JavaFileObject> generate(Iterable<? extends TypeElement> классы) throws IOException;
	Iterable<? extends TypeElement> enter() throws IOException;
	Iterable<? extends TypeElement> enter(Iterable<? extends CompilationUnitTree> деревья) throws IOException;
	Iterable<? extends TypeElement> enterTrees(Iterable<? extends CompilationUnitTree> деревья) throws IOException;
	Iterable<? extends Processor> getProcessors() throws RemoteException;
	JCTree.JCStatement parseStatement(CharSequence высказ, SourcePositions[] поз) throws RemoteException;
	JCTree.JCStatement parseStatement(CharSequence высказ, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки) throws RemoteException;
	JCTree.JCExpression parseExpression(CharSequence выраж, SourcePositions[] поз) throws RemoteException;
	JCTree.JCExpression parseExpression(CharSequence выраж, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки) throws RemoteException;
	JCTree.JCExpression parseVariableInitializer(CharSequence init, SourcePositions[] поз) throws RemoteException;
	JCTree.JCExpression parseVariableInitializer(CharSequence init, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки) throws RemoteException;
	JCTree.JCBlock parseStaticBlock(CharSequence блок, SourcePositions[] поз) throws RemoteException;
	JCTree.JCBlock parseStaticBlock(CharSequence блок, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки) throws RemoteException;
	Tree parseType(Строка выраж) throws RemoteException;
	Type parseType(Строка выраж, TypeElement сфера) throws RemoteException;
	Type attributeTree(JCTree дерево, Env<AttrContext> среда) throws RemoteException;
	JavacScope attributeTreeTo(JCTree дерево, Env<AttrContext> среда, JCTree до) throws RemoteException;
	Список<Env<AttrContext>> getTodo() throws RemoteException;
	Iterable<? extends CompilationUnitTree> parse() throws IOException;
	Iterable<? extends Element> analyze() throws IOException;
	Iterable<? extends JavaFileObject> generate() throws IOException;
	void setTaskListener(ТелеСлушательЗадачи tl) throws RemoteException;
	void addTaskListener(ТелеСлушательЗадачи tl) throws RemoteException;
	void removeTaskListener(ТелеСлушательЗадачи tl) throws RemoteException;
	TypeMirror getTypeMirror(Iterable<? extends Tree> деревья) throws RemoteException;
	JavacElements getElements() throws RemoteException;
	JavacTypes getTypes() throws RemoteException;
	ТелеОкружение getContextTele() throws RemoteException;
	void updateContext(Context новоеОкружение) throws RemoteException;
}
