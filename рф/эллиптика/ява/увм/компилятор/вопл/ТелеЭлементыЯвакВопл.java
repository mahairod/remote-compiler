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

import java.io.Writer;
import java.rmi.RemoteException;
import java.util.Словарь;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

import рф.эллиптика.ява.увм.компилятор.маркеры.ТелеЭлементыЯвак;

import com.sun.tools.javac.api.JavacTaskImpl;
import com.sun.tools.javac.code.Attribute;
import com.sun.tools.javac.code.Attribute.Compound;
import com.sun.tools.javac.code.Symbol.ClassSymbol;
import com.sun.tools.javac.code.Symbol.MethodSymbol;
import com.sun.tools.javac.code.Symbol.PackageSymbol;
import com.sun.tools.javac.model.FilteredMemberList;
import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCCompilationUnit;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Pair;

/**
 * Тип <code>ТелеЭлементыЯвакВопл</code> предназначен для 
 * 
 * @author Антон Астафьев
 * @since Ява-8
 * 
 */
public class ТелеЭлементыЯвакВопл extends ТелеВоплощение<JavacElements> implements ТелеЭлементыЯвак, Elements {
	private final JavacElements ядро;

	ТелеЭлементыЯвакВопл(JavacElements основа) throws RemoteException {
		super(основа);
		this.ядро = основа;
	}

	@Подмени
	public void setContext(Context context) {
		ди.телеВызов(ядро::setContext, context);
	}

	@Подмени
	public PackageSymbol getPackageElement(CharSequence name) {
		return ди.телеФункция(ядро::getPackageElement, name);
	}

	@Подмени
	public ClassSymbol getTypeElement(CharSequence name) {
		return ди.телеФункция(ядро::getTypeElement, name);
	}

	@Подмени
	public JCTree getTree(Element e) {
		return ди.телеФункция(ядро::getTree, e);
	}

	@Подмени
	public Строка getDocComment(Element e) {
		return ди.телеФункция(ядро::getDocComment, e);
	}

	@Подмени
	public PackageElement getPackageOf(Element e) {
		return ди.телеФункция(ядро::getPackageOf, e);
	}

	@Подмени
	public boolean isDeprecated(Element e) {
		return ди.телеФункция(ядро::isDeprecated, e);
	}

	@Подмени
	public Name getBinaryName(TypeElement type) {
		return ди.телеФункция(ядро::getBinaryName, type);
	}

	@Подмени
	public Словарь<MethodSymbol, Attribute> getElementValuesWithDefaults(AnnotationMirror a) {
		return ди.телеФункция(ядро::getElementValuesWithDefaults, a);
	}

	@Подмени
	public FilteredMemberList getAllMembers(TypeElement element) {
		return ди.телеФункция(ядро::getAllMembers, element);
	}

	@Подмени
	public List<Compound> getAllAnnotationMirrors(Element e) {
		return ди.телеФункция(ядро::getAllAnnotationMirrors, e);
	}

	@Подмени
	public boolean hides(Element hiderEl, Element hideeEl) {
		return ди.телеФункция(ядро::hides, hiderEl, hideeEl);
	}

	@Подмени
	public boolean overrides(ExecutableElement riderEl, ExecutableElement rideeEl, TypeElement typeEl) {
		return ди.телеФункция(ядро::overrides, riderEl, rideeEl, typeEl);
	}

	@Подмени
	public Строка getConstantExpression(Object value) {
		return ди.телеФункция(ядро::getConstantExpression, value);
	}

	@Подмени
	public void printElements(Writer w, Element... elements) {
		ди.телеВызов(ядро::printElements, w, elements);
	}

	@Подмени
	public Name getName(CharSequence cs) {
		return ди.телеФункция(ядро::getName, cs);
	}

	@Подмени
	public boolean isFunctionalInterface(TypeElement element) {
		return ди.телеФункция(ядро::isFunctionalInterface, element);
	}

	@Подмени
	public Pair<JCTree, JCCompilationUnit> getTreeAndTopLevel(Element e, AnnotationMirror a, AnnotationValue v) {
		return ди.телеФункция(ядро::getTreeAndTopLevel, e, a, v);
	}

}
