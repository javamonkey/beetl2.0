package org.beetl.performance.lab.asm;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class ASMGen implements Opcodes {

	public static byte[] dump() throws Exception {

		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		FieldVisitor fv;
		MethodVisitor mv;
		AnnotationVisitor av0;

		cw.visit(V1_6, ACC_PUBLIC + ACC_SUPER,
				"com/beetl/performance/lab/asm/UserAsmAccessor1", null,
				"java/lang/Object",
				new String[] { "com/beetl/performance/lab/asm/Access" });

		{
			mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 0);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>",
					"()V");
			mv.visitInsn(RETURN);
			mv.visitMaxs(1, 1);
			mv.visitEnd();
		}
		{
			mv = cw.visitMethod(
					ACC_PUBLIC,
					"get",
					"(Ljava/lang/Object;I)Ljava/lang/Object;",
					null,
					new String[] { "com/beetl/performance/lab/asm/ASMCastException" });
			mv.visitCode();
			Label l0 = new Label();
			Label l1 = new Label();
			Label l2 = new Label();
			mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
			mv.visitInsn(ACONST_NULL);
			mv.visitVarInsn(ASTORE, 3);
			mv.visitLabel(l0);
			mv.visitVarInsn(ALOAD, 1);
			mv.visitTypeInsn(CHECKCAST, "com/beetl/performance/lab/User");
			mv.visitVarInsn(ASTORE, 3);
			mv.visitLabel(l1);
			Label l3 = new Label();
			mv.visitJumpInsn(GOTO, l3);
			mv.visitLabel(l2);
			mv.visitFrame(Opcodes.F_FULL, 4, new Object[] {
					"com/beetl/performance/lab/asm/UserAsmAccessor",
					"java/lang/Object", Opcodes.INTEGER,
					"com/beetl/performance/lab/User" }, 1,
					new Object[] { "java/lang/Exception" });
			mv.visitVarInsn(ASTORE, 4);
			mv.visitTypeInsn(NEW,
					"com/beetl/performance/lab/asm/ASMCastException");
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL,
					"com/beetl/performance/lab/asm/ASMCastException", "<init>",
					"()V");
			mv.visitInsn(ATHROW);
			mv.visitLabel(l3);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitVarInsn(ILOAD, 2);
			Label l4 = new Label();
			Label l5 = new Label();
			Label l6 = new Label();
			mv.visitTableSwitchInsn(1, 2, l6, new Label[] { l4, l5 });
			mv.visitLabel(l4);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitVarInsn(ALOAD, 3);
			mv.visitMethodInsn(INVOKEVIRTUAL, "com/beetl/performance/lab/User",
					"getName", "()Ljava/lang/String;");
			mv.visitInsn(ARETURN);
			mv.visitLabel(l5);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitVarInsn(ALOAD, 3);
			mv.visitMethodInsn(INVOKEVIRTUAL, "com/beetl/performance/lab/User",
					"getId", "()I");
			mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf",
					"(I)Ljava/lang/Integer;");
			mv.visitInsn(ARETURN);
			mv.visitLabel(l6);
			mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
			mv.visitTypeInsn(NEW, "java/lang/RuntimeException");
			mv.visitInsn(DUP);
			mv.visitMethodInsn(INVOKESPECIAL, "java/lang/RuntimeException",
					"<init>", "()V");
			mv.visitInsn(ATHROW);
			mv.visitMaxs(2, 5);
			mv.visitEnd();
		}
		cw.visitEnd();

		return cw.toByteArray();
	}
}
