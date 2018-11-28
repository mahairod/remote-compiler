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

import java.io.Writer;
import java.rmi.RemoteException;
import java.util.Словарь;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;


import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.Attribute.Compound;
import com.sun.tools.javac.code.Symbol.ClassSymbol;
import com.sun.tools.javac.code.Symbol.MethodSymbol;
import com.sun.tools.javac.code.Symbol.PackageSymbol;
import com.sun.tools.javac.model.FilteredMemberList;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Pair;

/**
 * Тип <code>ТелеЭлементыЯвак</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public interface ТелеЭлементыЯвак extends СопряжениеТелеМаркер {

	void setContext(Context context) throws RemoteException;

	PackageSymbol getPackageElement(CharSequence name) throws RemoteException;

	ClassSymbol getTypeElement(CharSequence name) throws RemoteException;

	JCTree getTree(Element e) throws RemoteException;

	Строка getDocComment(Element e) throws RemoteException;

	PackageElement getPackageOf(Element e) throws RemoteException;

	boolean isDeprecated(Element e) throws RemoteException;

	Name getBinaryName(TypeElement type) throws RemoteException;

	Словарь<MethodSymbol, Attribute> getElementValuesWithDefaults(AnnotationMirror a) throws RemoteException;

	FilteredMemberList getAllMembers(TypeElement element) throws RemoteException;

	List<Compound> getAllAnnotationMirrors(Element e) throws RemoteException;

	boolean hides(Element hiderEl, Element hideeEl) throws RemoteException;

	boolean overrides(ExecutableElement riderEl, ExecutableElement rideeEl, TypeElement typeEl) throws RemoteException;

	Строка getConstantExpression(Object value) throws RemoteException;

	void printElements(Writer w, Element... elements) throws RemoteException;

	Name getName(CharSequence cs) throws RemoteException;

	boolean isFunctionalInterface(TypeElement element) throws RemoteException;

	Pair<JCTree, JCCompilationUnit> getTreeAndTopLevel(Element e, AnnotationMirror a, AnnotationValue v) throws RemoteException;

}
