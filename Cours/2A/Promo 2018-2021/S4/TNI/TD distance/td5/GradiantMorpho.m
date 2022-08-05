function [J] = GradiantMorpho(I)

    I_grad = double(I);
    GI = I_grad - erosion(I_grad);
    GE = dilatation(I_grad) - I_grad;
    J = GI - GE;
    figure(2); imshow(uint8(J))
end