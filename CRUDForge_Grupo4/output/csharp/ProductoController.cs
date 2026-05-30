using Microsoft.AspNetCore.Mvc;

namespace CRUDForge.Generated;

[ApiController]
[Route("api/[controller]")]
public class ProductoController : ControllerBase
{
    [HttpGet]
    public IActionResult Seleccionar() => Ok("Listado de Producto");

    [HttpPost]
    public IActionResult Insertar([FromBody] Producto item) => Ok(item);

    [HttpPut("{id}") ]
    public IActionResult Actualizar(string id, [FromBody] Producto item) => Ok(item);

    [HttpDelete("{id}") ]
    public IActionResult Borrar(string id) => Ok($"Registro {id} eliminado");
}
