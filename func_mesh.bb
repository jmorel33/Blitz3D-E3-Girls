;----------------------------------------------------------------------------------------
; Following are a collection of segment handling routines
;----------------------------------------------------------------------------------------
Function create_cube(segs=1,parent=0)
   mesh=CreateMesh( parent )
   For scnt=0 To 3
      surf=CreateSurface( mesh )
      stx#=-.5
      sty#=stx
      stp#=Float(1)/Float(segs)
      y#=sty
      For a=0 To segs
         x#=stx
         v#=a/Float(segs)
         For b=0 To segs
            u#=b/Float(segs)
            AddVertex(surf,x,y,0.5,u,v)
            x=x+stp
         Next
         y=y+stp
      Next
      For a=0 To segs-1
         For b=0 To segs-1
            v0 = a * (segs + 1) + b
            v1 = v0 + 1
            v2 = (a + 1) * (segs + 1) +  b + 1
            v3 = v2 - 1
            AddTriangle( surf, v0, v1, v2 )
            AddTriangle( surf, v0, v2, v3 )
         Next
      Next
      RotateMesh mesh,0,90,0
   Next
   ;top and bottom
   RotateMesh mesh,90,0,0
   For scnt=0 To 1
      surf=CreateSurface( mesh )
      stx#=-.5
      sty#=stx
      stp#=Float(1)/Float(segs)
      y#=sty
      For a=0 To segs
         x#=stx
         v#=a/Float(segs)
         For b=0 To segs
            u#=b/Float(segs)
            AddVertex(surf,x,y,0.5,u,v)
            x=x+stp
         Next
         y=y+stp
      Next
      For a=0 To segs-1
         For b=0 To segs-1
            v0=a*(segs+1)+b:v1=v0+1
            v2=(a+1)*(segs+1)+b+1:v3=v2-1
            AddTriangle( surf,v0,v1,v2 )
            AddTriangle( surf,v0,v2,v3 )
         Next
      Next
      RotateMesh mesh,180,0,0
   Next

   RotateMesh mesh,90,0,0
   ScaleMesh mesh,2,2,2
   UpdateNormals mesh
   Return mesh
End Function


Function create_flat(segs=1,parent=0)
   mesh=CreateMesh( parent )

   surf=CreateSurface( mesh )
   stx#=-.5
   sty#=stx
   stp#=Float(1)/Float(segs)
   y#=sty
   For a=0 To segs
      x#=stx
      v#=a/Float(segs)
      For b=0 To segs
         u#=b/Float(segs)
         AddVertex(surf,x,y,0.5,u,v)
         x=x+stp
      Next
      y=y+stp
   Next
   For a=0 To segs-1
      For b=0 To segs-1
         v0=a*(segs+1)+b:v1=v0+1
         v2=(a+1)*(segs+1)+b+1:v3=v2-1
         AddTriangle( surf,v0,v1,v2 )
         AddTriangle( surf,v0,v2,v3 )
      Next
   Next

   RotateMesh mesh,180,0,0
   ScaleMesh mesh,2,2,2
   UpdateNormals mesh
   Return mesh

End Function
