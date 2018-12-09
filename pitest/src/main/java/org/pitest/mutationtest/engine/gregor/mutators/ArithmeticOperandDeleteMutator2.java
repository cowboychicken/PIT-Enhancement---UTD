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

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.MethodVisitor;
import org.pitest.bytecode.ASMVersion;
import org.pitest.mutationtest.engine.MutationIdentifier;
import org.pitest.mutationtest.engine.gregor.MethodInfo;
import org.pitest.mutationtest.engine.gregor.MethodMutatorFactory;
import org.pitest.mutationtest.engine.gregor.MutationContext;

public enum ArithmeticOperandDeleteMutator2 implements MethodMutatorFactory {

  AOD_MUTATOR;

  @Override
  public MethodVisitor create(final MutationContext context, final MethodInfo methodInfo,
      final MethodVisitor methodVisitor) {
    return new AODVisitor(this, context, methodVisitor);
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

class AODVisitor extends MethodVisitor {

  private final MethodMutatorFactory factory;
  private final MutationContext context;

  AODVisitor(final MethodMutatorFactory factory, final MutationContext context,
      final MethodVisitor delegateMethodVisitor) {
    super(ASMVersion.ASM_VERSION, delegateMethodVisitor);
    this.factory = factory;
    this.context = context;
  }

  @Override
  public void visitInsn(final int opcode) {

    if (opcode == Opcodes.IADD) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.ISUB) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.IMUL) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.IDIV) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.IOR) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.IAND) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.IREM) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.IXOR) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.ISHL) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.ISHR) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.IUSHR) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LADD) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.LSUB) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LMUL) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LDIV) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LOR) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LAND) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LREM) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LXOR) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LSHL) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LSHR) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.LUSHR) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.FADD) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.FSUB) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.FMUL) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.FDIV) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.FREM) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.DADD) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }
    } else if (opcode == Opcodes.DSUB) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.DMUL) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.DDIV) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else if (opcode == Opcodes.DREM) {
      final MutationIdentifier newId = this.context.registerMutation(this.factory, "Mutated.");
      if (this.context.shouldMutate(newId)) {
        super.visitInsn(Opcodes.SWAP);
        super.visitInsn(Opcodes.POP);
      } else {
        super.visitInsn(opcode);
      }

    } else {
      super.visitInsn(opcode);
    }

  }
}