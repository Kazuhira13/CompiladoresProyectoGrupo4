from fastapi import FastAPI

app = FastAPI(title="CRUDForge API")

@app.get("/producto")
def seleccionar_producto(page:int=1, search:str=""):
    return {"entity":"Producto", "page":page, "search":search}

@app.post("/producto")
def insertar_producto(item:dict):
    return item

@app.put("/producto/{id}")
def actualizar_producto(id:str, item:dict):
    return item

@app.delete("/producto/{id}")
def borrar_producto(id:str):
    return {"deleted": id}
