package org.beetl.core.attr;

import org.beetl.core.exception.TempException;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.beetl.performance.lab.User;

public class ASMUtil implements Opcodes {

	class ASMClassLoader extends ClassLoader {
		public Class defineClass(String name, byte[] b) {
			return defineClass(name, b, 0, b.length);
		}
	}

	static ASMUtil util = new ASMUtil();
	private ASMClassLoader loader = new ASMClassLoader();

	private ASMUtil() {
		// TODO Auto-generated constructor stub
	}

	public static ASMUtil instance() {
		return util;
	}

	public AA createAAClass(Class c, String name,String methodName,Class returnType) {
		String cPath = c.getName().replace('.', '/');
		String newClsName = c.getName()+"$"+name;
		String newClsPath = newClsName.replace('.', '/');
		String returnTypeClass = this.getRetrunTypeDesc(returnType);
		
		ClassWriter cw = new ClassWriter(0);
		FieldVisitor fv;
		MethodVisitor mv;
		AnnotationVisitor av0;

		cw.visit(
				V1_6,
				ACC_PUBLIC + ACC_SUPER,
				newClsPath,
				null,
				"java/lang/Object",
				new String[] { "org/beetl/core/attr/AttributeAccessor" });

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
					"getAttribute",
					"(Ljava/lang/Object;ILjava/lang/String;)Ljava/lang/Object;",
					null, null);
			mv.visitCode();
			mv.visitVarInsn(ALOAD, 1);
			mv.visitTypeInsn(CHECKCAST, cPath);
			mv.visitMethodInsn(INVOKEVIRTUAL, cPath,
					methodName, "()"+returnTypeClass+";");
			mv.visitInsn(ARETURN);
			mv.visitMaxs(1, 4);
			mv.visitEnd();
		}
		cw.visitEnd();

		byte[] bs = cw.toByteArray();
		Class cls = loader.defineClass(newClsName, bs);
		try{
			return (AA) cls.newInstance();
		}catch(Exception ex){
			ex.printStackTrace();
			throw new TempException(ex.getMessage());
		}
		
	
		

	}
	
	private String getRetrunTypeDesc(Class c){
		StringBuilder sb = new StringBuilder();
		if(c.isArray()){
			sb.append("[");
		}
		
		if(c==int.class){
			sb.append("I");
		}else{
			sb.append("L").append(c.getName().replace(".", "/"));
		}
		return sb.toString();
	}
	
	public static void main(String[] args){
		ASMUtil util = ASMUtil.instance();
		AA aa = util.createAAClass(User.class, "name", "getName", String.class);
		User user = new User();
		String test = (String)aa.getAttribute(user, 0, "name");
		System.out.println(test);
		
	}
	

}
