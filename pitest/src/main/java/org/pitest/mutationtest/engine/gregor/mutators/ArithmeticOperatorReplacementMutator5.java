/*
 * Copyright 2010 Henry Coles
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and limitations under the License.
 */
package org.pitest.mutationtest.engine.gregor.mutators;

import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.pitest.mutationtest.engine.gregor.AbstractInsnMutator;
import org.pitest.mutationtest.engine.gregor.InsnSubstitution;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;
import org.pitest.mutationtest.engine.gregor.ZeroOperandMutation;

public enum ArithmeticOperatorReplacementMutator5 implements MethodMutatorFactory {

  MATH_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context,
      final MethodInfo methodInfo, final MethodVisitor methodVisitor) {
    return new MathMethodVisitor5(this, methodInfo, context, methodVisitor);
  }

  @Override
  public String getGloballyUniqueId() {
    return this.getClass().getName();
  }

  @Override
  public String getName() {
    return name();
  }

}

class MathMethodVisitor5 extends AbstractInsnMutator {

  MathMethodVisitor5(final MethodMutatorFactory factory,
      final MethodInfo methodInfo, final MutationContext context,
      final MethodVisitor writer) {
    super(factory, methodInfo, context, writer);
  }

  private static final Map<Integer, ZeroOperandMutation> MUTATIONS = new HashMap<>();

  static {
      
    // ints
    // 
    
     
     
    MUTATIONS.put(Opcodes.IADD, new InsnSubstitution(Opcodes.IAND,"Replaced integer addition with AND")); 
    MUTATIONS.put(Opcodes.ISUB, new InsnSubstitution(Opcodes.IREM,"Replaced integer subtraction with modulus")); 
    MUTATIONS.put(Opcodes.IMUL, new InsnSubstitution(Opcodes.IXOR,"Replaced integer multiplication with XOR")); 
    MUTATIONS.put(Opcodes.IDIV, new InsnSubstitution(Opcodes.ISHL,"Replaced integer division with Shift Left")); 
    MUTATIONS.put(Opcodes.IOR , new InsnSubstitution(Opcodes.ISHR,"Replaced bitwise OR with Shift Right")); 
    MUTATIONS.put(Opcodes.IAND, new InsnSubstitution(Opcodes.IUSHR,"Replaced bitwise AND with Unsigned Shift Right")); 
    MUTATIONS.put(Opcodes.IREM, new InsnSubstitution(Opcodes.IADD,"Replaced integer modulus with addition")); 
    MUTATIONS.put(Opcodes.IXOR, new InsnSubstitution(Opcodes.ISUB,"Replaced XOR with subtraction")); 
    MUTATIONS.put(Opcodes.ISHL, new InsnSubstitution(Opcodes.IMUL,"Replaced Shift Left with multiplication")); 
    MUTATIONS.put(Opcodes.ISHR, new InsnSubstitution(Opcodes.IDIV,"Replaced Shift Right with division")); 
    MUTATIONS.put(Opcodes.IUSHR, new InsnSubstitution(Opcodes.IOR ,"Replaced Unsigned Shift Right with OR")); 
     
    
    // longs
    //
    
    MUTATIONS.put(Opcodes.LADD, new InsnSubstitution(Opcodes.LAND,"Replaced integer addition with AND")); 
    MUTATIONS.put(Opcodes.LSUB, new InsnSubstitution(Opcodes.LREM,"Replaced integer subtraction with modulus")); 
    MUTATIONS.put(Opcodes.LMUL, new InsnSubstitution(Opcodes.LXOR,"Replaced integer multiplication with XOR")); 
    MUTATIONS.put(Opcodes.LDIV, new InsnSubstitution(Opcodes.LSHL,"Replaced integer division with Shift Left")); 
    MUTATIONS.put(Opcodes.LOR , new InsnSubstitution(Opcodes.LSHR,"Replaced bitwise OR with Shift Right")); 
    MUTATIONS.put(Opcodes.LAND, new InsnSubstitution(Opcodes.LUSHR,"Replaced bitwise AND with Unsigned Shift Right")); 
    MUTATIONS.put(Opcodes.LREM, new InsnSubstitution(Opcodes.LADD,"Replaced integer modulus with addition")); 
    MUTATIONS.put(Opcodes.LXOR, new InsnSubstitution(Opcodes.LSUB,"Replaced XOR with subtraction")); 
    MUTATIONS.put(Opcodes.LSHL, new InsnSubstitution(Opcodes.LMUL,"Replaced Shift Left with multiplication")); 
    MUTATIONS.put(Opcodes.LSHR, new InsnSubstitution(Opcodes.LDIV,"Replaced Shift Right with division")); 
    MUTATIONS.put(Opcodes.LUSHR, new InsnSubstitution(Opcodes.LOR ,"Replaced Unsigned Shift Right with OR")); 
     
     
  }

  @Override
  protected Map<Integer, ZeroOperandMutation> getMutations() {
    return MUTATIONS;
  }

}
