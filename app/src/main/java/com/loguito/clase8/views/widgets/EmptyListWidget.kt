package com.loguito.clase8.views.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.loguito.clase8.R
import com.loguito.clase8.databinding.EmptyListWidgetBinding

// TODO 2: Creamos la logica de negocio para el custom widget
class EmptyListWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    var imageClicked: ((Unit) -> Int)? = null

    private var _binding: EmptyListWidgetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    init {
        _binding = EmptyListWidgetBinding.inflate(LayoutInflater.from(context), this)

        // TODO 3: Accedemos a los atributos disponibles a traves del styleable
        attrs?.let {
            val typedArray = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.EmptyListWidget,
                defStyleAttr,
                defStyleRes
            )

            // TODO 4: Setemos los atributos a los componentes de UI
            binding.descriptionTextView.text =
                typedArray.getString(R.styleable.EmptyListWidget_description)

            binding.backgroundImageView.setImageDrawable(typedArray.getDrawable(R.styleable.EmptyListWidget_backgroundImage))

            binding.backgroundImageView.setOnClickListener {
                imageClicked?.invoke(Unit)
            }
        }
    }
}