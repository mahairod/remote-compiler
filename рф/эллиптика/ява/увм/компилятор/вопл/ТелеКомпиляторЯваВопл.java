package рф.эллиптика.ява.увм.компилятор.вопл;

import java.rmi.RemoteException;

import javax.tools.JavaFileObject;

import рф.эллиптика.ява.увм.КонстПарсера;
import рф.эллиптика.ява.увм.компилятор.маркеры.*;

import com.sun.tools.javac.api.JavacTool;
import com.sun.tools.javac.util.Context;

public class ТелеКомпиляторЯваВопл extends ТелеВоплощение<JavacTool> implements ТелеКомпиляторЯва {

	private static final long serialVersionUID = 3569366812258569302L;
	protected final JavacTool javaCompiler;

	public ТелеКомпиляторЯваВопл() throws RemoteException {
		this(JavacTool.create());
	}

	public ТелеКомпиляторЯваВопл(final JavacTool вопл) throws RemoteException {
		super(вопл);
		javaCompiler = вопл;
	}

	@Подмени @Подмени
	@ЗамолчиПредупреждения(КонстПарсера.Строка_Непровер_Oткл)
	public ТелеЗадачаЯвак getTask(ТелеПисатель out, ТелеРаспорядительФайлов распорядительФайлов, ТелеДиагностирующийСлушатель<? super JavaFileObject> diagnosticListener,
			ТелеПеребираемое<?> options, ТелеПеребираемое<?> classes, ТелеПеребираемое<? extends JavaFileObject> compilationUnits, ТелеОкружение окружение) throws RemoteException {

		окружение = о(окружение);
		окружение.согласуйСтатическиеКлючи(null);

		return  р( javaCompiler.getTask(
			ф(out),		 				ф(распорядительФайлов),
			ф(diagnosticListener),		ф(options),
			ф(classes),					ф(compilationUnits),
			(Context)окружение			)
		);
	}

}