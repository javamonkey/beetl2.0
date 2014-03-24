package org.beetl.core.resolver;

import org.beetl.core.exception.BeetlException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ASMUtil implements Opcodes
{

	class ASMClassLoader extends ClassLoader
	{
		public Class defineClass(String name, byte[] b)
		{
			return defineClass(name, b, 0, b.length);
		}
	}

	static ASMUtil util = new ASMUtil();
	private ASMClassLoader loader = new ASMClassLoader();

	private ASMUtil()
	{
		// TODO Auto-generated constructor stub
	}

	public static ASMUtil instance()
	{
		return util;
	}

	public AA createAAClass(Class c, String name, String methodName, Class returnType)
	{
		String cPath = c.getName().replace('.', '/');
		String newClsName = c.getName() + "$_" + name;
		String newClsPath = newClsName.replace('.', '/');
		String returnTypeClass = this.getRetrunTypeDesc(returnType);

		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

		MethodVisitor mv;

		cw.visit(V1_5, ACC_PUBLIC + ACC_SUPER, newClsPath, null, "org/beetl/core/resolver/AA", null);

		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "org/beetl/core/resolver/AA", "<init>", "()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(ACC_PUBLIC, "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", null,
					null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 1);
			mv.visitTypeInsn(CHECKCAST, cPath);
			mv.visitMethodInsn(INVOKEVIRTUAL, cPath, methodName, "()" + returnTypeClass);
			if (returnType.isPrimitive())
			{
				if (returnType == int.class)
				{
					mv.visitMethodInsn(INVOKESTATIC, "org/beetl/core/util/NumberUtil", "valueOf",
							"(I)Ljava/lang/Integer;");
				}
				else if (returnType == boolean.class)
				{
					mv.visitMethodInsn(INVOKESTATIC, "java/lang/Boolean", "valueOf", "(Z)Ljava/lang/Boolean;");

				}
				else if (returnType == char.class)
				{
					mv.visitMethodInsn(INVOKESTATIC, "java/lang/Character", "valueOf", "(C)Ljava/lang/Character;");

				}
				else if (returnType == short.class)
				{
					mv.visitMethodInsn(INVOKESTATIC, "java/lang/Short", "valueOf", "(S)Ljava/lang/Short;");

				}
				else if (returnType == float.class)
				{
					mv.visitMethodInsn(INVOKESTATIC, "java/lang/Float", "valueOf", "(F)Ljava/lang/Float;");

				}
				else if (returnType == long.class)
				{
					mv.visitMethodInsn(INVOKESTATIC, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;");

				}
				else if (returnType == double.class)
				{
					mv.visitMethodInsn(INVOKESTATIC, "java/lang/Double", "valueOf", "(D)Ljava/lang/Double;");

				}
			}

			mv.visitInsn(ARETURN);
			mv.visitMaxs(2, 3);
			mv.visitEnd();
		}
		cw.visitEnd();

		byte[] bs = cw.toByteArray();
		Class cls = loader.defineClass(newClsName, bs);
		try
		{
			return (AA) cls.newInstance();
		}
		catch (Exception ex)
		{
			BeetlException be = new BeetlException(BeetlException.OPT_ERROR, "不能创建一个属性访问类", ex);
			throw be;
		}

	}

	private String getRetrunTypeDesc(Class c)
	{
		StringBuilder sb = new StringBuilder();
		if (c.isArray())
		{
			sb.append("[");
			if (c.getComponentType().isArray())
			{
				sb.append("[");
			}
		}
		if (c == int.class)
		{
			sb.append("I");
		}
		else if (c == boolean.class)
		{
			sb.append("Z");
		}
		else if (c == char.class)
		{
			sb.append("C");
		}
		else if (c == short.class)
		{
			sb.append("S");
		}
		else if (c == float.class)
		{
			sb.append("F");
		}
		else if (c == long.class)
		{
			sb.append("J");
		}
		else if (c == double.class)
		{
			sb.append("D");
		}
		else
		{
			sb.append("L").append(c.getName().replace(".", "/")).append(";");
		}
		return sb.toString();
	}

}
