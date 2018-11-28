package рф.эллиптика.ява.увм;

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
import java.util.Список;
import javax.annotation.processing.Processor;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;

/**
 *
 * @author Антон Астафьев
 */
public interface СопряжениеЗадачаЯвак extends JavaCompiler.CompilationTask, РасширениеЗадачиЯвак {

}

interface БазоваяЗадачаЯвак {
	public Iterable<? extends CompilationUnitTree> parse() throws IOException;
	public Iterable<? extends Element> analyze() throws IOException;
	public Iterable<? extends JavaFileObject> generate() throws IOException;
	public void setTaskListener(TaskListener tl);
	public void addTaskListener(TaskListener tl);
	public void removeTaskListener(TaskListener tl);
	public TypeMirror getTypeMirror(Iterable<? extends Tree> деревья);
	public JavacElements getElements();
	public JavacTypes getTypes();
	public Context getContext();
	public void updateContext(Context новоеОкружение);
}

interface РасширениеЗадачиЯвак extends БазоваяЗадачаЯвак {
	public Iterable<? extends CompilationUnitTree> parse(JavaFileObject... файлы) throws IOException;
	public Iterable<? extends Element> analyze(Iterable<? extends TypeElement> классы) throws IOException;
	public Iterable<? extends JavaFileObject> generate(Iterable<? extends TypeElement> классы) throws IOException;

	public Iterable<? extends TypeElement> enter() throws IOException;
	public Iterable<? extends TypeElement> enter(Iterable<? extends CompilationUnitTree> деревья) throws IOException;
	public Iterable<? extends TypeElement> enterTrees(Iterable<? extends CompilationUnitTree> деревья) throws IOException;
	public Iterable<? extends Processor> getProcessors();
	
	@Deprecated
	JCTree.JCStatement parseStatement(CharSequence высказ, SourcePositions[] поз);
	JCTree.JCStatement parseStatement(CharSequence высказ, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки);
	@Deprecated
	JCTree.JCExpression parseExpression(CharSequence выраж, SourcePositions[] поз);
	JCTree.JCExpression parseExpression(CharSequence выраж, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки);
	@Deprecated
	JCTree.JCExpression parseVariableInitializer(CharSequence init, SourcePositions[] поз);
	JCTree.JCExpression parseVariableInitializer(CharSequence init, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки);
	
	@Deprecated
	JCTree.JCBlock parseStaticBlock(CharSequence блок, SourcePositions[] поз);
	JCTree.JCBlock parseStaticBlock(CharSequence блок, SourcePositions[] поз, DiagnosticListener<? super JavaFileObject> ошибки);
	
	Tree parseType(Строка выраж);
	Type parseType(Строка выраж, TypeElement сфера);

	Type attributeTree(JCTree дерево, Env<AttrContext> среда);
	JavacScope attributeTreeTo(JCTree дерево, Env<AttrContext> среда, JCTree до);
	
	Список<Env<AttrContext>> getTodo();
}

/*
abstract class JavacTaskImpl implements СопряжениеЗадачаЯвак {

	@Подмени
	public Main.Result doCall();

	@Подмени
	public abstract JavaFileObject asJavaFileObject(File file);

	@Подмени
	public abstract void generateTypeElements(Iterable<? extends TypeElement> classes) throws IOException;

	@Подмени
	public abstract void finish();

	@Подмени
	public abstract Iterable<? extends Tree> pathFor(CompilationUnitTree unit, Tree node);

	@Подмени
	public abstract String dumpTodo();

}
*/