package com.uol.api.client.container;

import com.uol.api.client.Vingadores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContainerVingadores {

    List<Vingadores> vingadores;
}
