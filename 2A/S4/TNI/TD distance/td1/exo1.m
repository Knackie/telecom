I = imread('Morpho.tif');
%median(I);
%I = dilatation(I);
%I = dilatation(I);
%I = dilatation(I);
%I = erosion(I);
%I = erosion(I);
%I = erosion(I);
I = GradiantMorpho(I);

cadre=zeros(256,256,'uint8');
cadre(:,1)=255;
cadre(:,256)=255;
cadre(256,:)=255;
cadre(1,:)=255;

E1=min(cadre,M);

%erosion(I);